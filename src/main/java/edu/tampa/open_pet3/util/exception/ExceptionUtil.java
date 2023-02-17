package edu.tampa.open_pet3.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionUtil {
    private static final Logger LOG= LoggerFactory.getLogger(ExceptionUtil.class);
    public static void check(boolean found,int id){

    }
    public static void check(boolean found,String msg){
        if(!found)throw new NotFoundException("WTF!!!");
    }
    public static <T> T check(T object,int id){
         return check(object,"id="+id);
    }
    public static <T>T check(T object,String msg){
        if(object==null)throw new NotFoundException("WTF!!!!!");
        return object;
    }
}
