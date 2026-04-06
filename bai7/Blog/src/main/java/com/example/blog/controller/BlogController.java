package com.example.blog.controller;

import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public String showList(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "searchName", defaultValue = "") String searchName) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("id").ascending());
        Page<Blog> blogPage = blogService.search(searchName, pageable);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("searchName", searchName);

        return "blog/list";
    }
    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.addBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Thêm mới blog thành công!");
        return "redirect:/blog";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id,
                         RedirectAttributes redirectAttributes){
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message","Xóa sản phẩm thành công");
        return "redirect:/blog";
    }
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam("id") int id, Model model){
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/update";
    }
    @PostMapping("/update")
    public String update(Blog blog){
        blogService.update(blog);
        return "redirect:/blog";
    }

}
