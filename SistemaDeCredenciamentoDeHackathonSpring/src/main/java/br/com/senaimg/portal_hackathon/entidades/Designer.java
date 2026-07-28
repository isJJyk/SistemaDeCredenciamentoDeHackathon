package br.com.senaimg.portal_hackathon.entidades;

public final class Designer extends Participante {
    String ferramentaVisual;

    public Designer(String nome, Integer idade, String matricula, String ferramentaVisual) {
        super(nome, idade, matricula);
        this.ferramentaVisual = ferramentaVisual;
    }

    @Override
    public String toString() {
        return "Designer: " + super.toString() + " ferramentaVisual: " + ferramentaVisual;
    }
}
