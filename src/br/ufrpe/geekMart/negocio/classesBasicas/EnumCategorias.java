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



    private final String estados;
    private EnumCategorias(String estados) {
        this.estados = estados;
    }

    public String getEstados(){
        return this.estados;
    }

    @Override
    public String toString() {
        return this.estados;
    }


}