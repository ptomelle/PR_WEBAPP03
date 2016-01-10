package Controller;

import javax.servlet.http.*;
import ModelAndView.*;
public class ControllerDefault
    implements ControllerInterface {

    @Override
    public ModelAndView handleRequest ( HttpServletRequest request, HttpServletResponse response )
    {
        ModelAndView mv = new ModelAndViewStandard();

        mv.setView("/default.html");
        mv.addObject("TITOLOPAGINA","DEFAULT ERROR");
        return  mv ;        
       
    }

}


