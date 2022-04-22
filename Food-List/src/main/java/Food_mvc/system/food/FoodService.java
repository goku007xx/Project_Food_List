package Food_mvc.system.food;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FoodService {
	private final FoodRepository foodRepository;
	
	@Autowired
	public FoodService(FoodRepository foodRepository) {
		this.foodRepository = foodRepository;
	}

	public List<Food> getFoods() {
		return foodRepository.findAll();
	}
	
	public Food saveItem(Food fd) {
		return foodRepository.save(fd);
	}
	
	public void deleteFoodById(Long id) {
		foodRepository.deleteById(id);
		
	}
}
