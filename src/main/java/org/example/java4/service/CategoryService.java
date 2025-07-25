package org.example.java4.service;

import org.example.java4.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(Long id);
    void add(Category category);
    void update(Category category);
    void delete(Long id);
    List<Category> searchByName(String keyword);
}

