package com.test.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "main";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    //public String render(@RequestParam String name, Model model) {
	public String render(@RequestParam (value="name", required=false) String name, Model model) {
        if (name == null) name = "";
        model.addAttribute("name", name);
        model.addAttribute("controller", this.getClass().getName());
        //model.addAttribute("controller", "MainController");
        
        logger.info("Get Call"); 
        
        return "render";
    }
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
    public String render_post(@RequestParam String name, Model model) {
        
        model.addAttribute("name", name);
        model.addAttribute("controller", this.getClass().getName());
        
        logger.info("Post Call"); 
        
        return "render";
    }
	
	@RequestMapping(value = "/error404", method = RequestMethod.GET)
    public String error404(HttpServletResponse res, Model model) {
		
		res.setStatus(HttpServletResponse.SC_OK);
		logger.warn("404 error occurred!!");
		model.addAttribute("contents", "error/error404");
        
        return "main";
    }
	
}
