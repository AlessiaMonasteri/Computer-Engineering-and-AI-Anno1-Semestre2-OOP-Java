package displayFile.generics;

public class RealFile implements FileDisplay {
    private String filePath;

    public RealFile (String filePath) {
        this.filePath = filePath;
        loadFile();
    }

    private void loadFile(){
        System.out.println("Loading file from " + filePath + "...");
    }

    @Override
    public void displayFileContent(){
        System.out.println("Displaying content of " + filePath);
    }
}