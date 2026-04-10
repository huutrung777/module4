package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "") String searchName) {

        Pageable pageable = PageRequest.of(page, 5,
                Sort.by("createDate").descending());

        Page<Blog> blogPage = blogService.search(searchName, pageable);

        model.addAttribute("blogPage", blogPage);
        model.addAttribute("searchName", searchName);

        return "blog/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Blog blog, RedirectAttributes ra) {
        blog.setCreateDate(LocalDateTime.now());
        blogService.addBlog(blog);
        ra.addFlashAttribute("message", "Thêm thành công!");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes ra) {
        blogService.delete(id);
        ra.addFlashAttribute("message", "Xóa thành công!");
        return "redirect:/blog";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "blog/update";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        Blog old = blogService.findById(blog.getId());
        blog.setCreateDate(old.getCreateDate());
        blogService.update(blog);
        return "redirect:/blog";
    }
}