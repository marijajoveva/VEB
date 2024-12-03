package mk.finki.ukim.mk.demo.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "booking_confirmation",urlPatterns = "/eventBooking")
public class BookingConfirmationServlet extends HttpServlet {
    private final SpringTemplateEngine engine;

    public BookingConfirmationServlet(SpringTemplateEngine engine) {
        this.engine = engine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        this.engine.process("bookingConfirmation.html",context,resp.getWriter());
    }
}
