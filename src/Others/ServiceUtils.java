package Others;

import java.util.Random;

public class ServiceUtils {
    public static String createCode(){
        Random r = new Random();
        int m = r.nextInt(45);
        int a = r.nextInt(10);
        int o = r.nextInt(20);
        return ""+m+a+o;
    }
}

