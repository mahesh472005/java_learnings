package com.mahesh.springboot_MVC.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home()
    {
        return "index";
    }

    /*We can pass the session attributes in various ways : */
    /*1. Using HttpServletRequest
      2. Using Direct parameters from the url
      3. Using RequestParam
      4. Using any of the above one, along with the Model Object*/

//    @RequestMapping("result")
//    public String result(HttpServletRequest request, HttpSession session)
//    {
//        int n1 = Integer.parseInt(request.getParameter("num1"));
//        int n2 = Integer.parseInt(request.getParameter("num2"));
//        session.setAttribute("result", n1+n2);
//        return "result.jsp";
//    }

//    @RequestMapping("result")
//    public String result(int num1, int num2,HttpSession session )
//    {
//        session.setAttribute("result", num1+num2);
//        return "result.jsp";
//    }

//    @RequestMapping("result")
//    public String result(@RequestParam("num1") int n1, @RequestParam("num2") int n2, HttpSession session )
//    {
//        session.setAttribute("result", n1+n2);
//        return "result.jsp";
//    }

//    @RequestMapping("result")
//    public String result(@RequestParam("num1") int n1, @RequestParam("num2") int n2, Model model )
//    {
//        model.addAttribute("result", n1+n2);
//        /* you will get null for the session variable result in the result.jsp page,
//           as we are not using the session here, hence it's value is null*/
//        return "result.jsp";
//    }

//    /* * To remove the .jsp and search in a specific location like views folder, we
//      need to set the prefix and suffix for in the application properties, then remove
//      the .jsp for index.jsp and result.jsp while returning it*/
//    @RequestMapping("result")
//    public String result(@RequestParam("num1") int n1, @RequestParam("num2") int n2, Model model )
//    {
//        model.addAttribute("result", n1+n2);
//        /* you will get null for the session variable result in the result.jsp page,
//           as we are not using the session here, hence it's value is null*/
//        return "result";
//    }

    /*To work with only data, we use Model object, if you want to Work with both
      data and view, then we can use ModelAndView Object, which will send both
      data along with the view i.e. result.jsp*/
//    @RequestMapping("result")
//    public ModelAndView result(@RequestParam("num1") int n1, @RequestParam("num2") int n2, ModelAndView mv )
//    {
//        mv.addObject("result", n1+n2);
//        mv.setViewName("result");
//        return mv;
//    }

}
