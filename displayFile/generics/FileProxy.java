package displayFile.generics;

public class FileProxy implements FileDisplay{
    private RealFile realFile;
    private String filePath;

    public FileProxy(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void displayFileContent() {
        
        if (realFile == null){
            realFile = new RealFile(filePath);
        }
        realFile.displayFileContent();
    }
    
}
