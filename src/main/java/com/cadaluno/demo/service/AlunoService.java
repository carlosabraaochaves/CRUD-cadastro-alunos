package com.cadaluno.demo.service;

import com.cadaluno.demo.entity.Aluno;

import java.util.List;

public interface AlunoService {

    List<Aluno> getAllAlunos();


   Aluno salvarAluno(Aluno aluno);

   Aluno getAlunoById(Long id);

    Aluno atualizaAluno(Aluno aluno);


    void excluirAlunoById(Long id);
}
