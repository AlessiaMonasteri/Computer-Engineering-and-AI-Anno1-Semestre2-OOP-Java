package displayFile;

import displayFile.generics.FileDisplay;
import displayFile.generics.FileProxy;

public class ProxyPattern {
    public static void main(String[] args){
         FileDisplay fileProxy = new FileProxy("large_file.txt");

         System.out.println("Calling displayFileContent() first time:");
         fileProxy.displayFileContent();

         System.out.println("\nCalling displayFileContent() second time:");
         fileProxy.displayFileContent();
    }
}