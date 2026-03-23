package com.example.spring_boot_data_jpa.controller;

import com.example.spring_boot_data_jpa.entity.SanPham;
import com.example.spring_boot_data_jpa.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    private ISanPhamService sanPhamService;
    @GetMapping(value = "")
    public String showList(Model model){
        List<SanPham> sanPhamList = sanPhamService.findAll();
        model.addAttribute("sanPhamList", sanPhamList);
        return "sanPham/list";
    }
    @GetMapping(value = "/add")
    public String showFormAdd(){
        return "sanPham/add";
    }
    @PostMapping("/add")
    public String save(SanPham sanPham,
                       RedirectAttributes redirectAttributes){

        sanPhamService.addSanPham(sanPham);

        redirectAttributes.addFlashAttribute("message","Thêm thành công");

        return "redirect:/san-pham";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id,
                         RedirectAttributes redirectAttributes){

        sanPhamService.delete(id);

        redirectAttributes.addFlashAttribute("message","Xóa sản phẩm thành công");

        return "redirect:/san-pham";
    }
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam("id") int id, Model model){
        SanPham sanPham = sanPhamService.findById(id);
        model.addAttribute("sanPham", sanPham);
        return "sanPham/update";
    }

    @PostMapping("/update")
    public String update(SanPham sanPham){
        sanPhamService.update(sanPham);
        return "redirect:/san-pham";
    }
    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model){

        List<SanPham> list = sanPhamService.searchByName(name);

        model.addAttribute("sanPhamList", list);

        return "sanPham/list";
    }


}
