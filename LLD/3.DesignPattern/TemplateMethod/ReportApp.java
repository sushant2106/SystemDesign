import java.util.*;

class ReportData {
    private List<String> headers;
    private List<Map<String, Object>> rows;

    public ReportData() {
        // Example headers
        headers = Arrays.asList("Product", "Quantity", "Price");

        // Example rows
        rows = new ArrayList<>();
        Map<String, Object> row1 = new HashMap<>();
        row1.put("Product", "Laptop");
        row1.put("Quantity", 5);
        row1.put("Price", 75000);
        rows.add(row1);

        Map<String, Object> row2 = new HashMap<>();
        row2.put("Product", "Phone");
        row2.put("Quantity", 10);
        row2.put("Price", 25000);
        rows.add(row2);
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }
}


abstract class AbstractReportExporter{
       
     public final void exportReport(ReportData data, String filePath) {

        prepareData(data);
        openFile(filePath);
        writeHeader(data);
        writeDataRows(data);
        writeFooter(data);    // Hook - optional override
        closeFile(filePath);
        System.out.println("Export complete: " + filePath);
     }
      
    // Concrete method - shared across all subclasses
     protected  void  prepareData(ReportData data){

     }

    // Concrete method - shared across all subclasses
    protected void openFile(String filePath) {
        System.out.println("Opening file: " + filePath);
    }
   
    // Abstract method - each subclass MUST implement
    protected abstract void  writeHeader(ReportData data);
    protected abstract void  writeDataRows(ReportData data);
   

     // Hook method - optional override with sensible default
    protected void writeFooter(ReportData data) {
        // Default: no footer. Subclasses can override if needed.
    }

    // Concrete method - shared across all subclasses
    protected void closeFile(String filePath) {
        System.out.println("Closing file: " + filePath);
    }

}

class CsvReportExporter extends  AbstractReportExporter{

    @Override 
    protected  void writeHeader(ReportData data){
        System.out.println("CSV: " + String.join(",", data.getHeaders()));
    }

    @Override
    protected void writeDataRows(ReportData data) {
        for (Map<String, Object> row : data.getRows()) {
            StringBuilder sb = new StringBuilder();
            for (String header : data.getHeaders()) {
                if (sb.length() > 0) sb.append(",");
                sb.append(row.get(header));
            }
            System.out.println("CSV: " + sb);
        }
    }
}

class PdfReportExporter extends AbstractReportExporter {
    @Override
    protected void writeHeader(ReportData data) {
        System.out.println("PDF: | " + String.join(" | ", data.getHeaders()) + " |");
        System.out.println("PDF: " + "-".repeat(40));
    }

    @Override
    protected void writeDataRows(ReportData data) {
        for (Map<String, Object> row : data.getRows()) {
            StringBuilder sb = new StringBuilder("PDF: | ");
            for (String header : data.getHeaders()) {
                sb.append(row.get(header)).append(" | ");
            }
            System.out.println(sb);
        }
    }

    @Override
    protected void writeFooter(ReportData data) {
        System.out.println("PDF: --- Page 1 of 1 ---");
    }
}


public class ReportApp{

    public static void main(String[] args) {
        ReportData data = new ReportData();

        AbstractReportExporter csvExporter = new CsvReportExporter();
        csvExporter.exportReport(data, "sales_report.csv");

        System.out.println();

        AbstractReportExporter pdfExporter = new PdfReportExporter();
        pdfExporter.exportReport(data, "sales_report.pdf");
    }
}