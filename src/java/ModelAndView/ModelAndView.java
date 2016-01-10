/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ModelAndView;

import java.util.HashMap;

/**
 *
 * @author paolotomelleri
 */
public interface ModelAndView {

    public void addObject(String property , Object obj);

    HashMap<String, Object> getMap();

    String getView();
    void setView(String view);

    
    boolean isRedirect();
    void setRedirect(boolean redirect);



}
