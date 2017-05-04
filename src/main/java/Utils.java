import org.reflections.Reflections;
import util.IUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    Reflections ref;
    List<IUtil> utilList;

    Utils(){
        ref = new Reflections("util");
        utilList = new ArrayList<>();
        loadCommands();
        run();
    }

    private void loadCommands(){
        //loads commands from the util package
        ref.getSubTypesOf(IUtil.class).forEach(subclass -> {
            try {
                utilList.add(subclass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private void run(){
        System.out.println("Select a utility: ");
        StringBuilder sb = new StringBuilder();
        Scanner scn = new Scanner(System.in);

        //loads options
        for(int i = 0; i < utilList.size(); i++){
            IUtil util = utilList.get(i);
            sb.append(i);
            sb.append(": ");
            sb.append(util.getName());
            if(i != 3) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
        int option = scn.nextInt();
        IUtil wanted = null;
        try{
            wanted = utilList.get(option);
        }
        catch (NullPointerException e){
            System.out.println("Invalid util");
        }

        if(wanted != null){
            while (true){
                wanted.run();
            }
        }

    }





    public static void main(String[] args) {
        Utils u = new Utils();

    }
}
