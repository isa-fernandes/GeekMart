package br.ufrpe.geekMart.negocio.classesBasicas;

import java.util.Arrays;
import java.util.List;

public enum CategoriasEnum {
    FIGURAS_ESTÁTUAS_E_BONECOS(Arrays.asList(SubcategoriasEnum.POP_FUNKO, SubcategoriasEnum.FILMES,
            SubcategoriasEnum.SÉRIES, SubcategoriasEnum.ANIMES, SubcategoriasEnum.HQS, SubcategoriasEnum.PLAY_ARTS,
            SubcategoriasEnum.HOT_TOY, SubcategoriasEnum.SH_FIGUARTS, SubcategoriasEnum.CLOTH_MYTH,
            SubcategoriasEnum.IRON_STUDIOS)),
    GAMES(Arrays.asList(SubcategoriasEnum.POKEMÓN, SubcategoriasEnum.MÁRIO_BROS, SubcategoriasEnum.HARRY_POTTER,
            SubcategoriasEnum.DISNEY)),
    CARD_GAMES(Arrays.asList(SubcategoriasEnum.YUGI_OH, SubcategoriasEnum.MAGIC, SubcategoriasEnum.DISNEY)),
    CAMISAS(Arrays.asList(SubcategoriasEnum.FILMES, SubcategoriasEnum.SÉRIES, SubcategoriasEnum.HQS,
            SubcategoriasEnum.ANIMES)),
    CANECAS(Arrays.asList(SubcategoriasEnum.ANIMES, SubcategoriasEnum.HQS, SubcategoriasEnum.BRINCOS,
            SubcategoriasEnum.SÉRIES, SubcategoriasEnum.MANGÁS)),
    ACESSÓRIOS(Arrays.asList(SubcategoriasEnum.BRINCOS, SubcategoriasEnum.CHAVEIROS, SubcategoriasEnum.COLARES,
            SubcategoriasEnum.PULSEIRAS)),
    HQS(Arrays.asList(SubcategoriasEnum.DC, SubcategoriasEnum.MARVEL, SubcategoriasEnum.STAR_WARS)),
    MANGÁS(Arrays.asList(SubcategoriasEnum.NARUTO, SubcategoriasEnum.DRAGON_BALL,
            SubcategoriasEnum.CAVALEIROS_DO_ZODÍACO, SubcategoriasEnum.YUGI_OH)),
    DVDS_E_CDS(Arrays.asList(SubcategoriasEnum.FILMES, SubcategoriasEnum.SÉRIES, SubcategoriasEnum.ANIMES)),
    COSPLAY(Arrays.asList(SubcategoriasEnum.ANIMES, SubcategoriasEnum.SÉRIES, SubcategoriasEnum.FILMES,
            SubcategoriasEnum.MANGÁS)),
    OUTROS(Arrays.asList());

    public List<SubcategoriasEnum> subcategorias;

    CategoriasEnum (List<SubcategoriasEnum> subcategoriasEnum) {
        this.subcategorias = subcategorias;
    }
}
