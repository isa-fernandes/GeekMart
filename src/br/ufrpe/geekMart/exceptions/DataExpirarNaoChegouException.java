package br.ufrpe.geekMart.exceptions;

import br.ufrpe.geekMart.negocio.classesBasicas.Anuncio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DataExpirarNaoChegouException extends Exception {
    private LocalDate data;
    private Anuncio anuncio;

    public DataExpirarNaoChegouException (LocalDate data, Anuncio anuncio) {
        super("A data de expiração " + data.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) +
                " do anúncio " + anuncio + " ainda não chegou.");
        this.anuncio = anuncio;
        this.data = data;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public LocalDate getData() {
        return data;
    }
}
