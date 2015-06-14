import java.io.IOException;
import java.util.zip.ZipFile;

/**
 * Created by dtabar on 6/14/15.
 */
public class ManejadorDeZip {

    ZipFile zip;

    public void openZipFile(String path){

        try {
            zip = new ZipFile(path);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfElements(){
        int numberOfElements = zip.size();
        return  numberOfElements;
    }
}
