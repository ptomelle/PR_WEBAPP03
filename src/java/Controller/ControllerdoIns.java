/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ApplicationContext.AppContext;
import ModelAndView.*;

import DAOManager.*;
import Domain.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;

public class ControllerdoIns implements ControllerInterface {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndViewStandard();

        try {
            DAOMan dao = (DAOMan) AppContext.getContext().get("DAO");
            //        public MOV(int id, int codintest, String descr, int coddest, BigDecimal importo, String data) {

            MOV m = new MOV(
                    Integer.parseInt(request.getParameter("id")),
                    Integer.parseInt(request.getParameter("codintest")),
                    request.getParameter("descr"),
                    Integer.parseInt(request.getParameter("coddest")),
                    BigDecimal.valueOf(Double.parseDouble(request.getParameter("importo"))),
                    request.getParameter("data")
            );

            dao.movDAO.add(m);
            mv.setView("insMOV.html");
            mv.addObject("TITOLOPAGINA", "Inserimento Movimenti");
            mv.addObject("ESITO", "Inserimento Corretto");

        
        }
        catch (java.sql.SQLIntegrityConstraintViolationException ex1){
                      mv.setView("insMOV.html");
            mv.addObject("TITOLOPAGINA", "Inserimento Movimenti");
            mv.addObject("ESITO", "Chiave duplicata");  
        }
        catch (Exception ex) {

            mv.setView("ErroreEccezione.html");
            mv.addObject("TITOLOPAGINA", "ERRORE");
            mv.addObject("eccezione", ex);
        }

        return mv;

    }
}
