
package ModelAndView;

import java.util.HashMap;


public class ModelAndViewStandard implements ModelAndView   {

    protected String  view = "/DefaultError.jsp";
    protected boolean redirect = false;
    HashMap<String,Object> map = new HashMap<String,Object>();


    @Override
    public String getView() {
        return view;
    }

    @Override
    public void setView(String viewJsp) {
        this.view = viewJsp;
    }
    

    @Override
    public boolean isRedirect() {
        return redirect;
    }

    @Override
    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }


    public ModelAndViewStandard() {
        super();                        // per abitudine meglio indicare super()
    }

    public ModelAndViewStandard(String view) {
        super();
        this.view = view;
    }

    /*
     * aggiunge un oggetto alla map come proprieta' prop
     * ob deve esporre le proprieta' con la convenzione dei JavaBean
     * in modo da essere direttamente utilizzabili in Jsp
     */
    @Override
    public void addObject ( String prop, Object ob){
        this.map.put(prop, ob);
    }

    /*
     * restiuisce la map per inserire le coppie nell'oggetto request
     */
    @Override
     public HashMap<String, Object> getMap() {
        return map;
    }




}