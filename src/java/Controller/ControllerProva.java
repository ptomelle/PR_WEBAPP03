/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



package Controller;

import ApplicationContext.AppContext;
import DAOManager.DAOMan;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ModelAndView.*;

public class ControllerProva implements ControllerInterface {

     // processRequest (HttpRequest request, HttpResponse response )

    @Override
    public ModelAndView handleRequest ( HttpServletRequest request, HttpServletResponse response )
    {
        // la gestione dell' errore andrebbe qui!!!
        
        ModelAndView mv = new ModelAndViewStandard();

        mv.setView("/prova.html");
        DAOMan d=(DAOMan)AppContext.getContext().get("DAOManager");

        mv.addObject("message", "MESSAGGIO DI PROVA DA SERVLET html");
        //mv.addObject("amici",d.getAll());
        return  mv;
    }

}
