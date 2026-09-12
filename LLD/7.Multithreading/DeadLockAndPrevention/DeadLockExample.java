
class BankAccount{

    private final String name;
    private int balance;

    public  BankAccount(String name,int balance){
        this.name=name;
        this.balance=balance;
    }

    public  String getName(){
        return name;
    }

    public synchronized void depoist(int amount){
        balance+=amount;
    }

    public  synchronized void  withdraw(int amount){
        balance-=amount;
    }

    public  int getBalance(){
        return  balance;
    }

}

class TransferTask implements  Runnable{
      
    private final BankAccount from;
    private  final BankAccount to;
    private  final int amount;

    public  TransferTask(BankAccount from,BankAccount to,int amount){
        this.from=from;
        this.to=to;
        this.amount=amount;

    }

    
    @Override 
    public void run(){

        synchronized(from){//T1 will take lock on from (A) //T2 will take lock from (B)
            System.out.println(Thread.currentThread().getName() + "Locked" + from.getName());
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            synchronized(to){ //T1 will try to take lock from to(B)  //T2 will try to take lock from to(A)
                System.out.println(Thread.currentThread().getName() + "Locked" + to.getName());
                from.withdraw(amount);
                to.depoist(amount);
                System.out.println("Transferred " + amount + " from " + from.getName() + " to " + to.getName());
                
            }

        }

    }

}


public class DeadLockExample{   

    public static void main(String[] args) {


        BankAccount accountA=new BankAccount("Account-A", 1000);
        BankAccount accountB=new BankAccount("Account-B", 1000);

        Thread t1=new Thread(new TransferTask(accountA, accountB, 100),"T1");
        Thread t2=new Thread(new TransferTask(accountA, accountB, 200),"T2");

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Finished..");
        
        
        
    }
}