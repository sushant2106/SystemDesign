public class Main {

    public static void main(String[] args) {
        
        BasicPrinter basic = new BasicPrinter();
        basic.print("report.pdf");

        OfficePrinter office = new OfficePrinter();
        office.print("memo.pdf");
        office.scan("memo.pdf");
        office.fax("memo.pdf", "555-1234");

        FullDevice full = new FullDevice();
        full.print("contract.pdf");
        full.scan("contract.pdf");
        full.fax("contract.pdf", "555-5678");
        full.staple("contract.pdf");

    }
    
}
