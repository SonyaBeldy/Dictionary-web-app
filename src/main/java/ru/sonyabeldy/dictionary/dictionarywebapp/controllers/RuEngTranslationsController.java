package ru.sonyabeldy.dictionary.dictionarywebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sonyabeldy.dictionary.dictionarywebapp.models.RuEngTranslation;
import ru.sonyabeldy.dictionary.dictionarywebapp.services.RuEngService;

import java.util.List;

@Controller
@RequestMapping("/dictionary")
public class RuEngTranslationsController {

    private final RuEngService ruEngService;

    public RuEngTranslationsController(RuEngService service) {
        this.ruEngService = service;
    }

    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("/show")
    public String show(Model model) {

        System.out.println("show");
        List<RuEngTranslation> translationList = ruEngService.findAll();
        model.addAttribute("translations", translationList);
        return "show";
    }

}
