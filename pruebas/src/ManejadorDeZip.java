import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by dtabar on 6/14/15.
 */
public class ManejadorDeZip {

    ZipFile zip;

    public void openZipFile(String path){

        try {
            this.zip = new ZipFile(path);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfElements(){
        int numberOfElements = this.zip.size();
        return  numberOfElements;
    }

    public String getEntryContent(ZipEntry entry){
        String text = null;
        InputStream inputStream = null;
        try {
            inputStream =  this.zip.getInputStream(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            text = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;

    }

    public ZipFile getZip(){
        return this.zip;
    }

    public Enumeration getEntries(){

        return this.zip.entries();
    }

    public ZipEntry getEntry(String nombre){
        return this.zip.getEntry(nombre);
    }
}
