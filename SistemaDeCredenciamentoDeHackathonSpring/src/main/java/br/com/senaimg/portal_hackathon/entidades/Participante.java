package br.com.senaimg.portal_hackathon.entidades;

public abstract class Participante {

    String nome;
    Integer idade;
    String matricula;

    public Participante(String nome, Integer idade, String matricula) {
        this.nome = nome;
        setIdade(idade);
        this.matricula = matricula;
    }

    public Participante() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        if (idade < 14 || idade > 21) {
            throw new IllegalArgumentException();
        }

        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "nome: " + nome + ", idade: " + idade + ", matricula: " + matricula;
    }
}
