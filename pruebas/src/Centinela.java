import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

/**
 * Created by dtabar on 6/15/15.
 * Revisa un cierto directorio cada 10 segundos
 * Si detecta un cambio imprime un mensaje y sale
 */
public class Centinela {

    private boolean cambio;

    public void vigilar(String directory){

        //Primer estado del directorio cuando comienza la vigilia
        List<String> originalFileNames = this.getDirectoryContents(directory);
        List<String> currentFileNames;
        this.cambio = false;

        while (!this.cambio){

            try {
                Thread.sleep(10000);
                currentFileNames = this.getDirectoryContents(directory);

                if(!currentFileNames.equals(originalFileNames)){
                    this.cambio = true;
                    System.out.println("Se ha detectado un cambio, saliendo!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private List<String> getDirectoryContents(String directory){
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return fileNames;
    }
}
