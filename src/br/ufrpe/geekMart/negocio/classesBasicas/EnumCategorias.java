package br.ufrpe.geekMart.negocio.classesBasicas;

public enum EnumCategorias {
    FIGURAS_ESTÁTUAS_E_BONECOS("Figuras, Estátuas e Action Figures"),
    GAMES("Games"),
    CARD_GAMES("Card Games"),
    CAMISAS("Camisas"),
    CANECAS("Canecas"),
    ACESSÓRIOS("Acessórios"),
    HQS("HQs"),
    MANGÁS("Mangás"),
    DVDS_E_CDS("DVDs e CDs"),
    COSPLAY("Cosplay"),
    OUTROS("Outros");



    private final String nome;
    private EnumCategorias(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }


}