package edu.tampa.open_pet3.web;


import edu.tampa.open_pet3.util.MealsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserMealsServlet extends HttpServlet {
    private static final Logger LOG= LoggerFactory.getLogger(UserMealsServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("meals", MealsUtil.getFiltered(MealsUtil.MEALS,2000));
        LOG.info("redirect started!");
        req.getRequestDispatcher("/UserMeal.jsp").forward(req,resp);
    }
}
