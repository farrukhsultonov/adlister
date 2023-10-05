package controllers;

import dao.Ads;
import dao.DaoFactory;
import models.Ad;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {



    private Ads adsDao;

    @Override
    public void init() throws ServletException {
        super.init();
        adsDao = DaoFactory.getAdsDao(); // Get an instance of the concrete implementation
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }

        long userId = user.getId();
        List<Ad> userAds = adsDao.findByUserId(userId);

        request.setAttribute("userAds", userAds);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}



