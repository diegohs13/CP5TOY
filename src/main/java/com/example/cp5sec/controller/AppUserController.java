package com.example.cp5sec.controller;

import com.example.cp5sec.domain.AppUser;
import com.example.cp5sec.repository.AppUserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import com.example.cp5sec.domain.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppUserController {

    @Autowired
    private AppUserRepository repository;

    @GetMapping("/register")
    public String register(Model model){
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute(registerDto);
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(
            Model model,
            @Valid @ModelAttribute RegisterDto registerDto,
            BindingResult bindingResult
    ) {
        try {
            var bCryptEncoder = new BCryptPasswordEncoder();

            AppUser appUser = new AppUser();
            appUser.setNome_completo(registerDto.getNome_completo());
            appUser.setUsername(registerDto.getUsername());
            appUser.setPassword(bCryptEncoder.encode(registerDto.getPassword()));
            appUser.setTelefone(registerDto.getTelefone());

            repository.save(appUser);


            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success", true);

        } catch (Exception e) {
            model.addAttribute("error", true);
        }
    return "register";
    }
}
