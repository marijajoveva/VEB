package mk.finki.ukim.mk.demo.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.demo.model.Event;
import mk.finki.ukim.mk.demo.service.EventService;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "event_list",urlPatterns = "/home")
public class EventListSevlet extends HttpServlet {
    private final EventService EventService;
    private final SpringTemplateEngine engine;
    private boolean search_check = false;

    private List<Event> found_events;

    public EventListSevlet(mk.finki.ukim.mk.demo.service.EventService eventService, SpringTemplateEngine engine) {
        EventService = eventService;
        this.engine = engine;
        found_events = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        context.setVariable("events",this.EventService.listAll());
        if(search_check){
            context.setVariable("searchEvents",found_events);
            found_events = new ArrayList<>();
            search_check = false;
        }
        this.engine.process("listEvents.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tmp = req.getParameter("redirect");
        if(tmp!=null){
            resp.sendRedirect("/eventBooking");
        }
        else{
            String text = req.getParameter("searchText");
            double rating = Double.parseDouble(req.getParameter("searchDesc"));
            found_events = EventService.specialSearch(text,rating);
            search_check = true;
            resp.sendRedirect("/home");
        }

    }
}
