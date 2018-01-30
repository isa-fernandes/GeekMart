package br.ufrpe.geekMart.negocio.classesBasicas;

public enum EnumEstrelas{ UMA("1"),
    DUAS("2"),
    TRÊS("3"),
    QUATRO("4"),
    CINCO("5");


    private final String estrelas;

    private EnumEstrelas(String estrelas) {
        this.estrelas = estrelas;
    }

    public String getEstrelas() {
        return this.estrelas;
    }

    @Override
    public String toString() {
        return this.estrelas;
    }

}


