public class CartBuilderDemo {

    public static class  CartBuilder{
        private String customer;
        private int itemCount;
        private double total;


        public  CartBuilder customer(String customer){
            this.customer=customer;
            return this;
        }

        public   CartBuilder items(int count){
            this.itemCount=count;
            return this;
        }

        public  CartBuilder total(double amount){
            this.total=amount;
            return  this;
        }

        
        public String build() {
            return "Cart{customer=" + customer + ", items=" + itemCount + ", total=$" + total + "}";
        }


    } 

    public static void main(String[] args) {
         String description = new CartBuilder()
            .customer("Alice")
            .items(3)
            .total(89.97)
            .build();

            System.out.println(description);

          //  String header="Content-Type,application/json";
    }

    
}
