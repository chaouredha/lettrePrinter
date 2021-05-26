package com.rcfactory.lp.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcfactory.lp.controllers.dto.LettrePrinterDTO;
import com.rcfactory.lp.service.LettrePrinterService;

@RestController
@RequestMapping("/lettre-printer")
public class LettrePrinterController {
    private final LettrePrinterService lettrePrinterService;

    public LettrePrinterController(LettrePrinterService lettrePrinterService) {
        this.lettrePrinterService = lettrePrinterService;
    }

    @PostMapping
    public String create(@RequestBody LettrePrinterDTO request) {
        return lettrePrinterService.lettrePrinter(request);
    }
}
