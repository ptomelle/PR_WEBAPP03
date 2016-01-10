/*
 * Implementa un semplice ApplicationContetxt
 * con una variabile static di tipo HashMap
 */
package ApplicationContext;

import java.util.HashMap;

/**
 *
 * @author paolotomelleri
 */
public class AppContext     {

    private static HashMap<String,Object> beanFactory =
            new HashMap<String,Object>();

    /**
     *
     * @return  beanFactory static
     */
    public static HashMap<String,Object> getContext() { return beanFactory ;}


    public AppContext () {
        // se istanza di AppContetxt, non fa nulla
    }

    /**
     *
     * @param argv
     */
    public static void main ( String argv[]){

        AppContext ap = new AppContext();
        HashMap<String,Object> hm = ap.getContext();
        hm.put("primo","Oggetto");


    }

}
