package com.rcfactory.lp.controllers.dto;

import lombok.Value;

@Value
public class LettrePrinterDTO {

    private final String word;
    private final Integer hauteur;
    private final Boolean vertical;
}
