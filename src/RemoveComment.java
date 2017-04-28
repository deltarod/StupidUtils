import java.io.*;
import java.util.Scanner;

//written to pull comments out of some C++ code, was originally commented out in an assembly file.

public class RemoveComment {

    private File file;
    private FileReader read;
    private Scanner inputScanner;

    private BufferedReader reader;

    private StringBuilder builder;

    private String wholeFile;

    public RemoveComment(){
        //sets up scanner for input
        inputScanner = new Scanner(System.in);
        loadFile();
        fileModify();

    }
    //loads file for modifications
    public void loadFile(){
        while (true) {
            if (file == null) {
                //gets path to file
                System.out.println("Enter Path: ");
                String path = inputScanner.nextLine();
                //String path = "F:\\Sophmore\\CS200\\PROJECT\\Project 10\\project10.cpp";
                file = new File(path);

            } else if (file.isFile()) {
                try {
                    read = new FileReader(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //loads file into reader
                reader = new BufferedReader(read);

                break;
            }
            else {
                //if not a file, retrys
                System.out.println("Not a File, Please retry \n");
                file = null;
            }
        }
    }

    //starts modifying the file
    public void fileModify(){
        //gets raw path without file name
        String path = file.getPath();
        String fileName = file.getName();
        path = path.replace(fileName, "");

        //gets extenstion
        int ext = fileName.lastIndexOf('.');
        String extenstion = fileName.substring(ext);

        //creates new path
        String name = fileName.substring(0,ext);
        String newPath = path + name + "new" + extenstion;
        File newFile = new File(newPath);

        //file writer creates a file, this deletes if wanted
        if(newFile.exists()){
            System.out.println("New File already made want to delete? Y/N");
            String yn = inputScanner.nextLine();
            yn = yn.toLowerCase();

            switch (yn){
                case "y":
                    newFile.delete();
                    break;
                default:
                    break;
            }
        }

        //new file writer
        FileWriter write = null;
        try {
            write = new FileWriter(newFile);
        }catch (Exception e){
            e.printStackTrace();
        }

        while (true){
            String line = null;
            try {
                line = reader.readLine();
            }catch (Exception e){e.printStackTrace();}
            //if readline is null doesnt do it
            if(line == null){
                try{
                    //close to save file
                    write.close();
                } catch (Exception e){e.printStackTrace();}
                break;
            }
            //deletes comments
            if(line.startsWith("# ")){
                line = line.substring(2) + "\n";
                //writes line to file
                try {
                    write.write(line);
                }
                catch (Exception e){e.printStackTrace();}

            }
        }
    }



    public static void main(String[] args) {
        RemoveComment comment = new RemoveComment();
    }
}
