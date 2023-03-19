package project109.backend.util;

import java.util.List;

public class AttributeCheck {
    public static boolean stringNotNull(String str){
        if(str==null||str=="") return false;
        else return true;
    }

    public static boolean listNotEmpty(List lst){
        if(lst==null||lst.isEmpty()) return false;
        else return true;
    }

    public static boolean indexNotNull(int index){
        if(index<0) return false;
        else return true;
    }
}
