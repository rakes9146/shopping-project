package net.rk.shoppingfrontend.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle ","The Page is not Constructed");
		mv.addObject("errorDescription","The page you are looking for that is not availabel now");
		mv.addObject("title","404 Error Page");
		
		return mv;
	}
	

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle ","Product Not Found");
		mv.addObject("errorDescription","The product you are looking for not available");
		mv.addObject("title","404 Error Page");
		
		return mv;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Contace Your Administrator");
		
		/* 
		 * Only for debugging your application
		 */
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription",sw.toString());
		mv.addObject("title","404 Error");
		
		return mv;
	}
	
}
