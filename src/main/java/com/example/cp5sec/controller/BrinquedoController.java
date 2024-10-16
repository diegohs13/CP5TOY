package com.example.cp5sec.controller;

import com.example.cp5sec.domain.Brinquedo;
import com.example.cp5sec.domain.BrinquedoDto;
import com.example.cp5sec.repository.BrinquedoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository repository;

    @GetMapping("/store")
    public String getAllBrinquedos(Model model){
        List<Brinquedo> todosBrinquedos = repository.findAll();
        model.addAttribute("brinquedo", todosBrinquedos);
        return "store";
    }

    @GetMapping("/store/add")
    public String add (Model model){
        BrinquedoDto brinquedoDto = new BrinquedoDto();
        model.addAttribute(brinquedoDto);
        model.addAttribute("success", false);
        return "add";
    }

    @PostMapping("/store/add")
    public String addBrinquedo(
            @Valid @ModelAttribute BrinquedoDto brinquedoDto,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            return "add";
        }

        try {
            Brinquedo brinquedo = new Brinquedo();
            brinquedo.setNome_brinquedo(brinquedoDto.getNome_brinquedo());
            brinquedo.setDescricao(brinquedoDto.getDescricao());
            brinquedo.setClassificacao(brinquedoDto.getClassificacao());
            brinquedo.setPreco(brinquedoDto.getPreco());

            repository.save(brinquedo);

            model.addAttribute("success", true);
            model.addAttribute("brinquedoDto", new BrinquedoDto());

        } catch (Exception e) {
            model.addAttribute("error", true);
        }

        return "add";
    }

    @GetMapping("/store/{id}/update")
    public String editarPreco(@PathVariable("id") int id, Model model) {
        Optional<Brinquedo> brinquedoOpt = repository.findById(id);

        if (brinquedoOpt.isPresent()) {
            Brinquedo brinquedo = brinquedoOpt.get();
            model.addAttribute("brinquedo", brinquedo);
            return "update";
        } else {
            return "redirect:/store";
        }
    }

    @PostMapping("/store/{id}/update")
    public String atualizarPreco(
            @PathVariable("id") int id,
            @Valid @ModelAttribute Brinquedo brinquedoAtualizado,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "update";
        }

        Optional<Brinquedo> brinquedoOpt = repository.findById(id);

        if (brinquedoOpt.isPresent()) {
            Brinquedo brinquedo = brinquedoOpt.get();
            brinquedo.setPreco(brinquedoAtualizado.getPreco());

            repository.save(brinquedo);
        }

        return "redirect:/store";
    }

    @PostMapping("/store/{id}/delete")
    public String deletarBrinquedo(@PathVariable("id") int id) {
        Optional<Brinquedo> brinquedoOpt = repository.findById(id);

        if (brinquedoOpt.isPresent()) {
            repository.deleteById(id);
        }

        return "redirect:/store";
    }

}
