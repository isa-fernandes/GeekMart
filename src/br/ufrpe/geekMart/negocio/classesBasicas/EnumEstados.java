package br.ufrpe.geekMart.negocio.classesBasicas;

public enum EnumEstados {
    AC("AC"), AL("AL"), AP("AP"), AM("AM"), BA("BA"), CE("CE"), DF("DF"), ES("ES"),
    GO("GO"), MA("MA"), MT("MT"), MS("MS"), MG("MG"), PA("PA"), PB("PB"), PR("PR"),
    PE("PE"), PI("PI"), RJ("RJ"), RN("RN"), RS("RS"), RO("RO"), RR("RR"), SC("SC"),
    SP("SP"), SE("SE"), TO("TO");



    private final String categorias;
    private EnumEstados(String categorias) {
        this.categorias = categorias;
    }

    public String getCategorias(){
        return this.categorias;
    }

    @Override
    public String toString() {
        return this.categorias;
    }


}
