/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import ApplicationContext.AppContext;
import ModelAndView.*;

import DAOManager.*;
import Domain.CCN;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.*;

public class ControllerListaCCN implements ControllerInterface {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndViewStandard();

        try {
            DAOMan dao = (DAOMan) AppContext.getContext().get("DAO");

            ArrayList<CCN> lc;
            lc = dao.ccnDAO.getListaCCN();
            mv.setView("ListaCCN.html");
            mv.addObject("TITOLOPAGINA", "Lista Conti correnti");
            mv.addObject("CCN", lc);
        } catch (Exception ex) {

            mv.setView("ErroreEccezione.html");
            mv.addObject("TITOLOPAGINA", "ERRORE");
            mv.addObject("eccezione", ex);
        }

        return mv;

    }
}
