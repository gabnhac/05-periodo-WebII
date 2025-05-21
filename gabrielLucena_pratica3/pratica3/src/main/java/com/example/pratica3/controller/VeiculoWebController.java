package com.example.pratica3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

import com.example.pratica3.model.Veiculo;
import com.example.pratica3.service.VeiculoService;

@Controller
@RequestMapping("/veiculos")
public class VeiculoWebController {
    private final VeiculoService veiculoService;

    public VeiculoWebController(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public String index(){
        return "redirect:/pessoas/listar";
    }

    @GetMapping("/cadastrar")
    public String exibirFormCadastro(Model model){
        model.addAttribute("veiculo", new Veiculo());
        return "veiculos/form";
    }

    @PostMapping("/cadastrar")
    public String cadastrarVeiculo(
        @Valid @ModelAttribute("veiculo") Veiculo veiculo,
        BindingResult result,
        RedirectAttributes ra
    ){
        if(result.hasErrors()){
            return "veiculos/form";
        }
        veiculoService.salvarVeiculo(veiculo);
        ra.addFlashAttribute("success", "Veiculo cadastrada com sucesso");
        return "redirect:/veiculos/listar";
    }

    @GetMapping("/listar")
    public String listarVeiculos(Model model){
        model.addAttribute("lista", veiculoService.listarVeiculos());
        return "veiculos/lista";
    }

    
}
