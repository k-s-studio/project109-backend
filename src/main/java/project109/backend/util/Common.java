package project109.backend.util;

import java.util.Random;

public class Common {

    public static String CreateRandomId(int length){
        String base= "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        StringBuffer id = new StringBuffer();
        for(int i=0; i<length; i++){
            int num=random.nextInt(62);
            id.append(base.charAt(num));
        }
        return id.toString();
    }
}
