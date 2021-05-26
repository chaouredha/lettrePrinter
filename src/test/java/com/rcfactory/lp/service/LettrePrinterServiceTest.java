package com.rcfactory.lp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.rcfactory.lp.controllers.dto.LettrePrinterDTO;
import com.rcfactory.lp.exceptions.LPException;
import com.rcfactory.lp.exceptions.LPMendatoryDataException;

@RunWith(SpringRunner.class)
public class LettrePrinterServiceTest {

    @InjectMocks
    private LettrePrinterService lettrePrinterService;

    @Test
    public void lettrePrinter() {
        String lettrePrinter = "\t     *    \n"
                + "\t    * *   \n"
                + "\t   *****  \n"
                + "\t  *     * \n"
                + "\t *       *\n"
                + "\t******\n"
                + "\t*\n"
                + "\t****\n"
                + "\t*\n"
                + "\t******\n"
                + "\t******\n"
                + "\t*\n"
                + "\t****\n"
                + "\t*\n"
                + "\t*\n";
        assertThat(lettrePrinterService.lettrePrinter(new LettrePrinterDTO("AEF", 5, true))).isEqualTo(lettrePrinter);
    }

    @Test
    public void lettrePrinterNotImplement() {
        assertThatThrownBy(() -> lettrePrinterService.lettrePrinter(new LettrePrinterDTO("X", 5, true)))
                .isInstanceOf(LPException.class);
    }

    @Test
    public void lettrePrinterAlphaNumeric() {
        assertThatThrownBy(() -> lettrePrinterService.lettrePrinter(new LettrePrinterDTO("1X", 5, true)))
                .isInstanceOf(LPMendatoryDataException.class);
    }

    @Test
    public void lettrePrinterNumeric() {
        assertThatThrownBy(() -> lettrePrinterService.lettrePrinter(new LettrePrinterDTO("1", 5, true)))
                .isInstanceOf(LPMendatoryDataException.class);
    }
}
