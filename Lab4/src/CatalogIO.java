import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CatalogIO {
    public CatalogIO() {

    }

    public CatalogIO(String pathString) {

        Path path = Paths.get(pathString);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void open(ArrayList<Graph> graphs, String fileName) {
        String fileImgPath = null;
        for (int i = 0; i < graphs.size(); i++) {
            if (graphs.get(i).getGraphName().equals(fileName)) {
                fileImgPath = graphs.get(i).getImgPath();
            }
        }
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop desktop = Desktop.getDesktop();
                File myFile = new File(fileImgPath);
                desktop.open(myFile);
            } catch (IllegalArgumentException e) {
                System.out.println("Ilegal Argument");
            } catch (IOException e) {
                System.out.println("IO Exception a");
            }
        }
    }

    protected void save(Catalog obj, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(obj);
            out.flush();
            fos.close();
            System.out.println("Object has been serialized");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("IOException at save");
        }
    }

    protected void load(Catalog obj, String fileName) {

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            obj = (Catalog) in.readObject();
            in.close();
            file.close();
        } catch (IOException ex) {
            System.out.println("IOException at load");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}
