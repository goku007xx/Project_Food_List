package Food_mvc.system.food;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodController {
	
	private FoodService foodService;

	@Autowired
	public FoodController(FoodService foodService) {
		super();
		this.foodService = foodService;
	}

	@GetMapping("/all_items")
	public String listitems(Model model) {
		model.addAttribute("items", foodService.getFoods());
		return "items_list"; // returns the items(a list of Food objects) as a model to a view named items_list in the templates folder
	}
	
	@GetMapping("/all_items/new")
	public String fruitform(Model model) {
		
		Food fd = new Food();
		model.addAttribute("item", fd);
		return "new_item";
	}
	
	@PostMapping("/all_items")
	public String saveItem(@ModelAttribute("item") Food fd) {
		foodService.saveItem(fd);
		return "redirect:/all_items";
	}
	
	@GetMapping("/all_items/{id}")
	public String deleteStudent(@PathVariable Long id) {
		foodService.deleteFoodById(id);
		return "redirect:/all_items";
	}

	
}
