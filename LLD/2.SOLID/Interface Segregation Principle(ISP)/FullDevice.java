public class FullDevice  implements Printable,Scannable,Faxable,Stapleable{


     @Override
    public void print(String document) {
        System.out.println("OfficePrinter -> Printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("OfficePrinter -> Scanning: " + document);
    }

    @Override
    public void fax(String document, String number) {
        System.out.println("OfficePrinter -> Faxing: " + document + " to " + number);
    }

    @Override
    public void staple(String document) {
        System.out.println("FullDevice -> Stapling: " + document);
    }
}

