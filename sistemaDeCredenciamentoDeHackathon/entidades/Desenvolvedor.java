package sistemaDeCredenciamentoDeHackathon.entidades;

public final class Desenvolvedor extends Participante {
    String linguagemFavorita;

    public Desenvolvedor(String nome, Integer idade, String matricula, String linguagemFavorita) {
        super(nome, idade, matricula);
        this.linguagemFavorita = linguagemFavorita;
    }

    @Override
    public String toString() {
        return "Desenvolvedor: "+super.toString()+ " linguagemFavorita: " + linguagemFavorita;
    }
}
