package com.example.KT_Java.service;

import com.example.KT_Java.entity.PhongBan;
import com.example.KT_Java.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongBanRepository;
    public List<PhongBan> getAllPhongBan(){
        return phongBanRepository.findAll();
    }

    public PhongBan savePhongBan(PhongBan savePhongBan){ return phongBanRepository.save(savePhongBan);}

    public void deletePhongBan(Long id){
        phongBanRepository.deleteById(id);
    }
    public PhongBan getPhongBanById(Long id) {return phongBanRepository.findById(id).orElse(null);}
}
