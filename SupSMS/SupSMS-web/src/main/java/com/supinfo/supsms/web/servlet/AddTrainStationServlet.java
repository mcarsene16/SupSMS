package com.supinfo.supsms.web.servlet;


import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.service.IUtilisateurService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bargenson
 */
@WebServlet(name = "AddTrainStationServlet", urlPatterns = {"/admin/train-stations/add"})
public class AddTrainStationServlet extends HttpServlet {

    @EJB
    private IUtilisateurService utilisateurService;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/addTrainStation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = new Utilisateur();
        u.setNom("Guindo");
        u.setPrenom("Rouky");
        u.setLogin("rouky23");
        u.setPassword("23assanatou");
        Utilisateur u1 = new Utilisateur();
        u1.setNom("Chagour");
        u1.setPrenom("Habib");
        u1.setLogin("admin ");
        u1.setPassword("admin");
//        trainStation.setAddress(req.getParameter("address"));
//        trainStation.setCity(req.getParameter("city"));
        
        this.utilisateurService.ajouter(u);
        this.utilisateurService.ajouter(u1);
        
        resp.sendRedirect(req.getContextPath() + "/train-stations");
    }
    
}
