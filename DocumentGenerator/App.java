
public class App {
    public static void main(String[] args) {
        DocumentGenerator htmlDocument = new HTMLDocument();
        DocumentGenerator pdfDocument = new PDFDocument();

        System.out.println("Generating HTML Document:");
        htmlDocument.generateDocument();

        System.out.println("\nGenerating PDF Document:");
        pdfDocument.generateDocument();
    }
}