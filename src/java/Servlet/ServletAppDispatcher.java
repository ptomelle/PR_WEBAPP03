/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ApplicationContext.AppContext;
import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import ModelAndView.*;

import Controller.*;
import DAOManager.*;
import freemarker.template.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServletAppDispatcher extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Front Controller per tutte le servlet Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Viene cercato il controller associato a questa richiesta servlet
        ControllerInterface c = this.getHandler(request);

        // il controller selezionato produce tutte le info per il rendering
        // in una map , mentre in una var ha il nome della pagina da renderizzare
        ModelAndView mv = c.handleRequest(request, response);

        // in mv e' stata settato il nome della pagina da rendere e 
        // quindi se questa pagina e' un html oppure json ecc.
        // sara' importante quando si usara' il template.
        // in questo caso solo il nome della pagina
        rendering(mv.getView(), mv, response);

    }

    /*
     *  init()
     *  questo metodo viene chiamato prima di qualsiasi chiamata della
     *  Servlet e in questo punto si devono  mettere le inizializzazioni.
     *
     *  Viene chiamata una volta sola
     *
     */
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

        // Qui si istanzia DAOMan
        DAOMan daoManager=null;
        daoManager = new DAOMan();

        //  Qui si aggiunge DAOMan ad application context
        AppContext.getContext().put("DAO", daoManager);
        // successivamente tutti gli oggetti globali vengono inseriti
        // ..AppContext.getContext().put("..",...);
        
        Configuration cfg = new freemarker.template.Configuration();

        cfg.setServletContextForTemplateLoading(getServletContext(), "FTL");
        AppContext.getContext().put("CfgTemplate", cfg);
        
    }

    /* GetHandler
     * con l'informazione contenuta nella querystring
     * restituuisce il controller addetto alla gestione della richiesta
     *
     */
    ControllerInterface getHandler(HttpServletRequest request) {
        ControllerInterface c = null;

       
        String nomeServletReq = request.getPathInfo();
        
        

        
        if (nomeServletReq.equals("/")) {
            c = new ControllerDefault();
        }
        
        if (nomeServletReq.equals("/ListaCCN")) {
            c = new ControllerListaCCN();
        }
        if (nomeServletReq.equals("/insMOV")) {
            c = new ControllerInsMOV();
        }        
        if (nomeServletReq.equals("/doINS")) {
            c = new ControllerdoIns();
        }        
        if (c == null) {
            c = new ControllerDefault();
        }
        return c;
    }

    /*
     * incapsula le operazioni di rendering ed
     * effettua il rendering della pagina risposta
     */
    void rendering(String view, ModelAndView mv, HttpServletResponse response){
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String contentType = "text/html;charset=UTF-8";
            if (view.endsWith("json"))
                contentType = "text/json;charset=UTF-8";
            if (view.endsWith("xml"))
                contentType = "text/xml;charset=UTF-8";
            response.setContentType(contentType);
            freemarker.template.Configuration cfg;
            cfg = (freemarker.template.Configuration) AppContext.getContext().get("CfgTemplate");
            String pathTemplate = view + ".ftl";
            Template template = cfg.getTemplate(pathTemplate);
            template.process(mv.getMap(), out);
            out.close();
            
            /* gestione senza freemarker
            
            //String contextServelet = getServletContext().getContextPath();
            if (view.equals("/prova.html")) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
            out.println("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<body>");
            //---------- stampare    contenuto mv
            out.print(mv.getView());
            List<String> l = (List<String>) mv.getMap().get("amici");
            for (String s : l) {
            out.print("<h3>" + s + "</h3>\n");
            
            }//---------- fine stampa contenuto mv
            out.print("</body>");
            out.print("</html> ");
            
            
            } finally {
            out.close();
            }

            }
*/      } catch (IOException ex) {
            Logger.getLogger(ServletAppDispatcher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(ServletAppDispatcher.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

//  NON SCRIVERE SOTTO QUESTA RIGA
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
