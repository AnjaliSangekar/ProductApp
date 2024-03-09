package com.example.demo.category;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository repo;
	
	@GetMapping("/categories")
	public String listCategories(Model model)
	{
		List<Category> listCategories = repo.findAll();
		
		model.addAttribute("listCategories", listCategories);
		
		return "categories"; 
	}
	
	@GetMapping("/categories/new")
	public String showCategoryForm(Model model)
	{
		model.addAttribute("category", new Category());
		
		return "categories_form";
	}
	
	@PostMapping("/categories/save")
	public String saveCatgeory(Category category)
	{
		repo.save(category);
		
		return "redirect:/categories";
	}
}
