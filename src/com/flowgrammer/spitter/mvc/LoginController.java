package com.flowgrammer.spitter.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flowgrammer.spitter.domain.Spittle;

@Controller
@RequestMapping("/login")
public class LoginController {
  @RequestMapping(method=RequestMethod.GET)
  public String showLoginForm(Model model) {
	    model.addAttribute(new Spittle());
	    return "home";
  }
}
