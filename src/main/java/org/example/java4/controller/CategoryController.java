package org.example.java4.controller;

import org.example.java4.model.Category;
import org.example.java4.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return "category-list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.getById(id));
        return "category-detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/category/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.getById(id));
        return "category-update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category) {
        categoryService.update(category);
        return "redirect:/category/hien-thi";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("category", new Category());
        return "category-add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Category category) {
        categoryService.add(category);
        return "redirect:/category/hien-thi";
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("categories", categoryService.searchByName(keyword));
        return "category-list";
    }
}


