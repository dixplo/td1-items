package edu.spring.td1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import edu.spring.td1.models.Element;

@Controller
@SessionAttributes("items")
public class MainController {
	
	@ModelAttribute("items") 
    protected List<Element> getItems(){
        List<Element> items= new ArrayList<>();
        items.add(new Element("Café"));
        items.add(new Element("Thé"));
        return items;
    }
	
	@GetMapping("/items")
	public String items() {
		return "items";
	}

	@GetMapping("/items/new")
	public String formItem() {
		return "formItem";
	}
	
	@PostMapping("/items/addNew")
	public RedirectView addNew(@RequestParam String nom,@SessionAttribute List<Element> items) {
		items.add(new Element(nom));
		return new RedirectView("/items");
	}
	
	@GetMapping("/items/inc/{nom}")
	public RedirectView inc(@PathVariable String nom,@SessionAttribute  List<Element> items) {
		Element elm=getElementByNom(nom, items);
		if(elm!=null) {
			elm.inc();
		}
		return new RedirectView("/items");
	}

	@GetMapping("/items/dec/{nom}")
	public RedirectView dec(@PathVariable String nom,@SessionAttribute  List<Element> items) {
		Element elm=getElementByNom(nom, items);
		if(elm!=null) {
			elm.dec();
		}
		return new RedirectView("/items");
	}
	
	private Element getElementByNom(String nom,List<Element> items) {
		for(Element elm:items) {
			if(nom.equals(elm.getNom())) {
				return elm;
			}
		}
		return null;
	}

	
	
}
