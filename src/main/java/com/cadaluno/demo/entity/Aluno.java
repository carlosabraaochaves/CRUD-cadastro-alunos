package com.cadaluno.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aluno")
    private Long id;


    @Column(name = "nome", nullable = false)
    private String nome;


    private String sobreNome;

    private int idade;

    private String email;

    public String getNome() {
        return nome;
    }


    public Aluno(){

    }

    public Aluno(String nome, String sobreNome, int idade, String email) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
