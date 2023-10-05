package controllers;
import dao.DaoFactory;
import models.User;
import util.Password;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // store form information
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        String hashedPassword = Password.hash(password);    // hash the password

        boolean passwordConfirmation = password.equals(confirmPassword);

        // check username for unique, email/password entry
        User existingUser = DaoFactory.getUsersDao().findByUsername(username);

        if (username.isEmpty()){
            System.out.println("Please enter a username");
            request.getRequestDispatcher("/WEB-INF/fixUsername.jsp").forward(request, response);
            return;
        }

        if (existingUser != null) {
            System.out.println("This username is taken");
            request.getRequestDispatcher("/WEB-INF/fixUsername.jsp").forward(request, response);
            return;
        }
        if (email.isEmpty()) {
            System.out.println("Please enter email");
            request.getRequestDispatcher("/WEB-INF/fixEmail.jsp").forward(request, response);
            return;
        }
        if (password.isEmpty() || !passwordConfirmation) {
            System.out.println("Please enter/confirm your password");
            request.getRequestDispatcher("/WEB-INF/fixPassword.jsp").forward(request, response);
            return;
        }

        // create and save a new user
        User user = new User(username, email, hashedPassword);

        // add new user to database
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}