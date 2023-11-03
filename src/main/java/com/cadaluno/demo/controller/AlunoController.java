package com.cadaluno.demo.controller;


import com.cadaluno.demo.entity.Aluno;
import com.cadaluno.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlunoController {

    @Autowired
    private AlunoService alunoService;


    @GetMapping("/alunos")
    public String listarAluno(Model model){

        model.addAttribute("alunos", alunoService.getAllAlunos());

        return "alunos";
    }
    @GetMapping("/alunos/cadastro")
    public String cadastraAlunoViaForm(Model model){
        Aluno aluno = new Aluno();
        model.addAttribute("aluno",aluno);
        return "cadastrarAluno";
    }


    @PostMapping
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno){
        alunoService.salvarAluno(aluno);
        return "redirect:/alunos";
    }


    @GetMapping("/alunos/cadastro/editar/{id}")
    public String editarAlunoViaForm(@PathVariable Long id, Model model){

        model.addAttribute("aluno",alunoService.getAlunoById(id));
        return "atualizarAluno";
    }

@PostMapping("alunos/{id}")
    public String AtualizarAluno(@PathVariable  Long id, @ModelAttribute("aluno") Aluno aluno, Model model) {
        Aluno existenciaDeAluno = alunoService.getAlunoById(id);

        existenciaDeAluno.setIdade(aluno.getIdade());
        existenciaDeAluno.setNome(aluno.getNome());
        existenciaDeAluno.setSobreNome(aluno.getSobreNome());
        existenciaDeAluno.setIdade(aluno.getIdade());
        existenciaDeAluno.setEmail(aluno.getEmail());

         alunoService.salvarAluno(existenciaDeAluno);

        return "redirect:/alunos";
    }

    @GetMapping("/alunos/cadastro/excluir/{id}")
    public String excluirAlunoViaForm(@PathVariable Long id){

       alunoService.excluirAlunoById(id);
        return "redirect:/alunos";
    }
}
