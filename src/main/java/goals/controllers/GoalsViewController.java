package goals.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import goals.models.Goals;
import goals.repositories.GoalsRepository;


@Controller
@RequestMapping("/ui")
public class GoalsViewController {
	
	@Autowired
	GoalsRepository goalRepository;

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/goals")
	public String goals(Model model) {
		
		List<Goals> goals = this.goalRepository.findAll();
		model.addAttribute("goals", goals);
		
		
		
		return "goals";
	}
}
