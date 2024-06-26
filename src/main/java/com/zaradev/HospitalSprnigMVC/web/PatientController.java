package com.zaradev.HospitalSprnigMVC.web;

import com.zaradev.HospitalSprnigMVC.entities.Patient;
import com.zaradev.HospitalSprnigMVC.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name= "page", defaultValue="0") int page,
                        @RequestParam(name= "size", defaultValue="4") int size,
                        @RequestParam(name= "keyword", defaultValue="") String kw
                        ) {
        Page<Patient> patientsPage = patientRepository.findByNomContains(kw, PageRequest.of(page,size));
        model.addAttribute("listPatients", patientsPage.getContent());
        model.addAttribute("pages", new int[patientsPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete (Long id, int page, String keyword) {
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

}
