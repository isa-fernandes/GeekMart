package br.ufrpe.geekMart.negocio.classesBasicas;

import java.util.ArrayList;

public class Categorias {
    private static ArrayList<String> categoriasX = new ArrayList<>();


    public Categorias() {


    }

    public static ArrayList<String> getCategorias() {
        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("Figuras, estatuas e bonecos");
        categorias.add("Games");
        categorias.add("Card Games");
        categorias.add("Camisas");
        categorias.add("Canecas");
        categorias.add("Acessórios");
        categorias.add("HQs");
        categorias.add("Mangás");
        categorias.add("DVDs e CDs");
        categorias.add("Cosplay");
        categorias.add("Outros");
        categorias.add("Animes");
        return categorias;
    }

    public static void setCategorias(ArrayList<String> categorias) {
        Categorias.categoriasX = categorias;
    }



    /*
    public static String getCategoria (int i) {
        return categorias[i];
    }

    public static String[] listarCategorias(){
        return categorias;
    }

    public static void setCategorias (int num, String novaCategoria) {
        categorias[num] = novaCategoria;
        if (num > 30) {
            qtCategorias++;
        }
    }

    public static int encontrarCategoria (String categoria) {
        int i;
        for (i = 0; i < qtCategorias; i++) {
            if (categoria.equals(categorias[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String toStringPrincipal () {
        int i, f;
        String s = "[1] " + categorias[0] + "\n";
        for (i = 1; i < 11; i++) {
            f = i;
            f++;
            s = s + "[" + f + "] " + categorias[i];
            if (f < 11) {
                s = s  + "\n";
            }
        }
        return s;
    }

    public static String toStringSubcategorias (int i) {
        String results;
        switch (i) {
            case 1: {
                results = "[1] " + categorias[24] + "\n" + "[2] " + categorias[36] + "\n" + "[3] " + categorias[37] + "\n"
                        + "[4] " + categorias[11] + "\n" + "[5] " + categorias[6] + "\n" + "[6] " + categorias[23] + "\n"
                        + "[7] " + categorias[20] + "\n" + "[8] " + categorias[22] + "\n" + "[9] " + categorias[21] + "\n"
                        + "[10] " + categorias[25];
                break;
            }
            case 2: {
                results = "[1] " + categorias[38] + "\n" + "[2] " + categorias[39];
                break;
            }
            case 3: {
                results = "[1] " + categorias[18] + "\n" + "[2] " + categorias[19];
                break;
            }
            case 4: {
                results = "[1] " + categorias[36] + "\n" + "[2] " + categorias[37] + "\n" + "[3] " + categorias[11] + "\n"
                        + "[4] " + categorias[6];
                break;
            }
            case 5: {
                results = "[1] " + categorias[34] + "\n" + "[2] " + categorias[37] + "\n" + "[3] " + categorias[6] + "\n"
                        + "[4] " + categorias[11] + "\n" + "[5] " + categorias[7];
                break;
            }
            case 6: {
                results = "[1] " + categorias[31] + "\n" + "[2] " + categorias[32] + "\n" + "[3] " + categorias[33] + "\n"
                        + "[4] " + categorias[34];
                break;
            }
            case 7: {
                results = "[1] " + categorias[16] + "\n" + "[2] " + categorias[15] + "\n" + "[3] " + categorias[27];
                break;
            }
            case 8: {
                results = "[1] " + categorias[18] + "\n" + "[2] " + categorias[12] + "\n" + "[3] " + categorias[14] + "\n"
                        + "[4] " + categorias[13];
                break;
            }
            case 9: {
                results = "[1] " + categorias[36] + "\n" + "[2] " + categorias[37] + "\n" + "[3] " + categorias[11];
                break;
            }
            case 10: {
                results = "[1] " + categorias[36] + "\n" + "[2] " + categorias[37] + "\n" + "[3] " + categorias[11] + "\n"
                        + "[4] " + categorias[6];
                break;
            }
            default: {
                results = null;
            }
        }
        return results;
    }

    public static int pegarCategoriaEscolhida (int caso, int opcao) {
        int returnn = -1;
        switch (caso) {
            case 1: {
                if (opcao == 1) returnn = 24;
                else if (opcao == 2) returnn = 36;
                else if (opcao == 3) returnn = 37;
                else if (opcao == 4) returnn = 11;
                else if (opcao == 5) returnn = 6;
                else if (opcao == 6) returnn = 23;
                else if (opcao == 7) returnn = 20;
                else if (opcao == 8) returnn = 22;
                else if (opcao == 9) returnn = 21;
                else if (opcao == 10) returnn = 25;
                break;
            }
            case 2: {
                if (opcao == 1) returnn = 38;
                else if (opcao == 2) returnn = 39;
                break;
            }
            case 3: {
                if (opcao == 1) returnn = 18;
                else if (opcao == 2) returnn = 19;
                break;
            }
            case 4: {
                if (opcao == 1) returnn = 36;
                else if (opcao == 2) returnn = 37;
                else if (opcao == 3) returnn = 11;
                else if (opcao == 4) returnn = 6;
                break;
            }
            case 5: {
                if (opcao == 1) returnn = 34;
                else if (opcao == 2) returnn = 37;
                else if (opcao == 3) returnn = 6;
                else if (opcao == 4) returnn = 11;
                else if (opcao == 5) returnn = 7;
                break;
            }
            case 6: {
                if (opcao == 1) returnn = 31;
                else if (opcao == 2) returnn = 32;
                else if (opcao == 3) returnn = 33;
                else if (opcao == 4) returnn = 34;
                break;
            }
            case 7: {
                if (opcao == 1) returnn = 16;
                else if (opcao == 2) returnn = 15;
                else if (opcao == 3) returnn = 27;
                break;
            }
            case 8: {
                if (opcao == 1) returnn = 18;
                else if (opcao == 2) returnn = 12;
                else if (opcao == 3) returnn = 14;
                else if (opcao == 4) returnn = 13;
                break;
            }
            case 9: {
                if (opcao == 1) returnn = 36;
                else if (opcao == 2) returnn = 37;
                else if (opcao == 3) returnn = 11;
                break;
            }
            case 10: {
                if (opcao == 1) returnn = 36;
                else if (opcao == 2) returnn = 37;
                else if (opcao == 3) returnn = 11;
                else if (opcao == 4) returnn = 6;
                break;
            }
        }
        return returnn;
    }*/

}
