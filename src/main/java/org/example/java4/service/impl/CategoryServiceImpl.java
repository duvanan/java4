package org.example.java4.service.impl;

import org.example.java4.model.Category;
import org.example.java4.repositories.CategoryRepository;
import org.example.java4.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public void add(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public List<Category> searchByName(String keyword) {
        return categoryRepo.findByCategoryNameContainingIgnoreCase(keyword);
    }
}
