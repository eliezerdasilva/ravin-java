package br.com.devxlabs.ravin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;


@Controller
public class HelloWorldController {
	
	@GetMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("message","Ola mundo");
	
		return "helloWorld";
		
	}
	@GetMapping("/helloWorldPlain")
	@ResponseBody
	public String helloWorldPlain() {
		return "TEste hello";
	}

}
