package com.example.KT_Java.service;

import com.example.KT_Java.entity.NhanVien;
import com.example.KT_Java.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    public List<NhanVien> getAllNhanVien(){
        return nhanVienRepository.findAll();
    }

    public void updateNhanVien(NhanVien updateNhanVien){nhanVienRepository.save(updateNhanVien);
    }
    public NhanVien getNhanVienByMa_NV(String Ma_NV)
    {
        return nhanVienRepository.findById(Ma_NV).orElse(null);
    }
    public void deleNhanVien(String Ma_NV) {
        NhanVien nhanVien =nhanVienRepository.findById(Ma_NV).orElse(null);
        if (nhanVien != null) {
            nhanVienRepository.delete(nhanVien);
        }
    }
    public void addNhanVien(NhanVien addNhanVien){
        nhanVienRepository.save(addNhanVien);
    }
}
