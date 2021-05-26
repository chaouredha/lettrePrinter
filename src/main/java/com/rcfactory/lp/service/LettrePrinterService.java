package com.rcfactory.lp.service;

import static java.lang.Character.toUpperCase;
import static org.apache.commons.lang3.StringUtils.normalizeSpace;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.rcfactory.lp.controllers.dto.LettrePrinterDTO;
import com.rcfactory.lp.exceptions.LPException;
import com.rcfactory.lp.exceptions.LPMendatoryDataException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LettrePrinterService {

    public String lettrePrinter(LettrePrinterDTO lettrePrinterDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!isAlpha(lettrePrinterDTO.getWord())) {
            throw new LPMendatoryDataException(String.format("%s doit etre une chaine de caractere", lettrePrinterDTO.getWord()));
        }
        if (lettrePrinterDTO.getVertical() != null && lettrePrinterDTO.getVertical()) {
            return lettrePrinter(lettrePrinterDTO, stringBuilder);
        }
        return lettrePrinter(lettrePrinterDTO, stringBuilder).replace("\n", "");
    }

    private String lettrePrinter(LettrePrinterDTO lettrePrinterDTO, StringBuilder stringBuilder) {
        for (int i = 0; i < lettrePrinterDTO.getWord().length(); i++) {
            char lettre = lettrePrinterDTO.getWord().charAt(i);
            stringBuilder.append(printPattern(toUpperCase(lettre), lettrePrinterDTO.getHauteur()));
        }
        return stringBuilder.toString();
    }

    private String printPattern(char character, Integer hauteur) {
        switch (character) {
            case 'A':
                return printA(hauteur);
            case 'E':
                return printE(hauteur);
            case 'F':
                return printF(hauteur);
            default:
                throw new LPException(
                        String.format("Aucun affichage de ne correspond à la valeur %s",
                                character));
        }
    }

    private String printA(Integer hauteur) {
        StringBuilder sb = new StringBuilder();
        char[][] table = new char[hauteur * 2][hauteur * 2];
        String str = "\t";
        int n = hauteur * 2 / 2;
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < hauteur * 2; j++) {
                if (j == n || j == ((hauteur * 2) - n) || (i == hauteur / 2 && j < ((hauteur * 2) - n)) && j > n) {
                    table[i][j] = '*';
                    str += table[i][j];
                } else {
                    table[i][j] = ' ';
                    str += table[i][j];
                }
            }
            n--;
            sb.append(str);
            sb.append("\n");
            str = "\t";
        }
        return sb.toString();
    }

    private String printE(Integer hauteur) {
        StringBuilder stringBuilder = new StringBuilder();
        char[][] table = new char[hauteur][hauteur];
        String str = "\t";
        for (int i = 0; i < hauteur; i++) {
            table[i][0] = '*';
            str += table[i][0];
            for (int j = 0; j < hauteur; j++) {
                if ((i == 0 || i == hauteur - 1)
                        || (i == hauteur / 2
                        && j <= hauteur / 2)) {
                    table[i][j] = '*';
                    str += table[i][j];
                }
            }
            stringBuilder.append(str);
            stringBuilder.append("\n");
            str = "\t";
        }
        return stringBuilder.toString();
    }

    private String printF(int hauteur) {
        StringBuilder stringBuilder = new StringBuilder();
        char[][] table = new char[hauteur][hauteur];
        String str = "\t";
        for (int i = 0; i < hauteur; i++) {
            table[i][0] = '*';
            str += table[i][0];
            for (int j = 0; j < hauteur; j++) {
                if ((i == 0) || (i == hauteur / 2
                        && j <= hauteur / 2)) {

                    table[i][j] = '*';
                    str += table[i][j];
                }
            }
            stringBuilder.append(str);
            stringBuilder.append("\n");
            str = "\t";
        }
        return stringBuilder.toString();
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
}
