package edu.tampa.open_pet3.web.user;


import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.repositories.InMemoryUserMealRepository;
import edu.tampa.open_pet3.repositories.UserMealRepository;
import edu.tampa.open_pet3.util.UserMealsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Objects;


public class UserMealsServlet extends HttpServlet {
    private static final Logger LOG= LoggerFactory.getLogger(UserMealsServlet.class);
    private UserMealRepository userMealRepository;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        userMealRepository=new InMemoryUserMealRepository();
    }


    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException {
         req.setCharacterEncoding("UTF-8");
         String id=req.getParameter("id");
         UserMeal userMeal=new UserMeal(id.isEmpty()?null:Integer.valueOf(id),
                 LocalDateTime.parse(req.getParameter("localDateTime")),
                 req.getParameter("description"),
                 Integer.parseInt(req.getParameter("calories")));
         LOG.info(userMeal.isNew()?"Create: {}":"Update: {}",userMeal);
         userMealRepository.save(userMeal);
         resp.sendRedirect("/Open-pet3/userMeals");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if(action==null){
            LOG.info("getAll");
            req.setAttribute("meals",UserMealsUtil.getFilteredMealsWithExceeded(
                    (List<UserMeal>)userMealRepository.getAll(),LocalDateTime.of(2015, Month.MAY,30,10,0).toLocalTime(),
                    LocalDateTime.of(2015, Month.MAY,31,20,0).toLocalTime(),2000));
            req.getRequestDispatcher("/UserMeal.jsp").forward(req,resp);
        }
        else if(action.equals("delete")){
            int id=getId(req);
            LOG.info("Delete: {}",id);
            userMealRepository.delete(id);
            resp.sendRedirect("/Open-pet3/userMeals");
        }else{
            final UserMeal meal=action.equals("create")?new UserMeal(LocalDateTime.now(),"",1000)
                    :userMealRepository.get(getId(req));
            req.setAttribute("meal",meal);
            req.getRequestDispatcher("/mealEdit.jsp").forward(req,resp);
        }
    }
    private int getId(HttpServletRequest request){
        String paramId= Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
