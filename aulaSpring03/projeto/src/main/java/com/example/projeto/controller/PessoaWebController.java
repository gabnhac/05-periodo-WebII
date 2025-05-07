package main.java.com.example.projeto.controller;

import com.example.projeto.service.PessoaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.BindingResult;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/pessoas")
public class PessoaWebController {
    private final PessoaService PessoaService;

    public PessoaWebController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    // Mapeia get/pessoas -> redireciona para /pessoas/listar

    @GetMapping
    public String index(){
        return "redirect:/pessoas/listar";
    }

    // pag 1

    @GetMapping("/cadastrar")
    public String exibirFormCadastro(Model model){
        model.addAttribute("pessoa", new Pessoa());
        
        return "pessoas/form";
    }

    @PostMapping("cadastrar")
    public String cadastrarPessoa(
        @Valid @ModelAttribute("pessoa") Pessoa pessoa,
        BindingResult result,
        RedirectAttributes ra
    ){
        if(result.hasErrors()){
            // repopula o objeto no formulário em caso de erro
            return "pessoas/form";
        }
        pessoaService.salvarPessoa(pessoa);
        ra.addFlashAttribute("sucesso", "Pessoa cadastrada com sucesso!");
        return "redirect:/pessoas/listar";
    }

    // pag 2. Página de listagem
    
    @GetMapping("listar")
    public String listarPessoas(Model model){
        model.addAttribute("lista", pessoaService.listarPessoas());
        return "pessoas/lista";
    }

    // pag 3. Detalhes e exclusão

    @GetMapping("/{id}")
    public String detalhesPesoa(@PathVariable Long id, Model model){
        Pessoa p = pessoaService.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Pessoa não encontrada, id: " + id
        ));
        
        model.addAttribute("pessoa", p);
        return "pessoas/detalhe";
    }

    @DeleteMapping("/{id}")
    public String excluirPessoa(@PathVariable Long id, RedirectAttributes ra){
        pessoaService.deletarPessoa(id);
        ra.addAttribute("sucesso", "Pessoa excluída com sucesso");
        return "redirect:/pessoas/listar";
    }
}
