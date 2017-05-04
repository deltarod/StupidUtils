import org.reflections.Reflections;
import util.IUtil;

import java.util.Set;

public class Calc {
    Reflections ref;

    Calc(){
        ref = new Reflections("util");

        loadCommands();
    }

    private void loadCommands(){

        Set<Class<? extends IUtil>> calcSet = ref.getSubTypesOf(IUtil.class);
        for(Class<? extends IUtil> calcClass : calcSet){
            IUtil util;
            try {
                util = calcClass.newInstance();
            }
            catch (InstantiationException e){
                e.printStackTrace();
            }
            catch (IllegalAccessException e){
                e.printStackTrace();
            }

        }

    }





    public static void main(String[] args) {
        Calc c = new Calc();

    }
}
