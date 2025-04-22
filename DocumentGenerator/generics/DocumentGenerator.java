public abstract class DocumentGenerator {
    public final void generateDocument() {
        openDocument();
        addTitle();
        addContent();
        closeDocument();
    }

    protected abstract void openDocument();
    protected abstract void addTitle();
    protected abstract void addContent();
    protected abstract void closeDocument();
}

class HTMLDocument extends DocumentGenerator {
    @Override
    protected void openDocument() {
        System.out.println("Opening HTML document...");
    }

    @Override
    protected void addTitle() {
        System.out.println("<h1>Document Title</h1>");
    }

    @Override
    protected void addContent() {
        System.out.println("<p>This is the content of the HTML document.</p>");
    }

    @Override
    protected void closeDocument() {
        System.out.println("Closing HTML document.");
    }
}

class PDFDocument extends DocumentGenerator {
    @Override
    protected void openDocument() {
        System.out.println("Opening PDF document...");
    }

    @Override
    protected void addTitle() {
        System.out.println("[PDF Title: Document Title]");
    }

    @Override
    protected void addContent() {
        System.out.println("[PDF Content: This is the content of the PDF document.]");
    }

    @Override
    protected void closeDocument() {
        System.out.println("Closing PDF document.");
    }
}
