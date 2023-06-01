package com.example.KT_Java.controller;


import com.example.KT_Java.entity.NhanVien;
import com.example.KT_Java.entity.PhongBan;
import com.example.KT_Java.service.NhanVienService;
import com.example.KT_Java.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/TrangChu")
public class NVController {
    @Autowired
    private NhanVienService nhanvienService;

    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String index(Model model) {
        List<NhanVien> nhanVien = nhanvienService.getAllNhanVien();
        model.addAttribute("nhanVien", nhanVien );
        return "nhanvien/list";
    }
    @GetMapping("/create")
    public String addFormNhanVien(Model model){
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBan", phongBanService.getAllPhongBan());
        return "nhanvien/create";
    }
    @PostMapping("/create")
    public String addNhanVien(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("phongBan",phongBanService.getAllPhongBan());
            return "nhanvien/create";
        }
        nhanvienService.addNhanVien(nhanVien);
        return "redirect:/TrangChu";
    }
    @GetMapping("/delete/{Ma_NV}")
    public String deleteNhanVien(@PathVariable("Ma_NV") String Ma_NV, Model model){
        NhanVien nhanVien = nhanvienService.getNhanVienByMa_NV(Ma_NV);
        nhanvienService.deleNhanVien(Ma_NV);
        return "redirect:/TrangChu";
    }
    @GetMapping("/edit/{Ma_NV}")
    public String edit(@PathVariable("Ma_NV") String Ma_NV, Model model){
        model.addAttribute("nhanVien", nhanvienService.getNhanVienByMa_NV(Ma_NV));
        model.addAttribute("phongBan", phongBanService.getAllPhongBan());
        return "nhanvien/edit";
    }
    @PostMapping("/edit")
    public String edit(@Valid NhanVien editNhanVien, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("nhanVien", editNhanVien);
            model.addAttribute("phongBan",phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }
        nhanvienService.updateNhanVien(editNhanVien);
        return "redirect:/TrangChu";
    }
}
