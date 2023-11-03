package com.cadaluno.demo.service;

import com.cadaluno.demo.entity.Aluno;
import com.cadaluno.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService{


    @Autowired
    private AlunoRepository repository;


    @Override
    public List<Aluno> getAllAlunos(){
        return repository.findAll();
    }

    @Override
    public Aluno salvarAluno(Aluno aluno) {
        return repository.save(aluno);
    }

    @Override
    public Aluno getAlunoById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Aluno atualizaAluno(Aluno aluno) {
        return repository.save(aluno);
    }

    @Override
    public void excluirAlunoById(Long id) {

        repository.deleteById(id);

    }


}
