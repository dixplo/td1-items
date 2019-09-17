package edu.spring.td1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	
	@ModelAttribute("items") 
    protected List<String> getItems(){
        return new ArrayList<>();
    }
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/items")
	public String items() {
		return "items";
	}

	
	
	@GetMapping("/items/inc/{nom}/{icons}")
	public String inc(@PathVariable String nom,@PathVariable String icons) {
		return "index";
	}
}
