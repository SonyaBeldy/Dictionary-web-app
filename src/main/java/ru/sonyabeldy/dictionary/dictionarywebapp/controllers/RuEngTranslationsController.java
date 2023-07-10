package ru.sonyabeldy.dictionary.dictionarywebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.sonyabeldy.dictionary.dictionarywebapp.models.RuEngTranslation;
import ru.sonyabeldy.dictionary.dictionarywebapp.models.SprintTask;
import ru.sonyabeldy.dictionary.dictionarywebapp.services.RuEngService;

import java.util.*;

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
        model.addAttribute("translations", ruEngService.findAll());
        return "show";
    }


    @PostMapping("/test")
    public String get(@RequestParam(value="test", required = false) int[] test, RedirectAttributes redirectedAttributes) {
        if(test != null) {
            redirectedAttributes.addAttribute("test", test);
            return "redirect:test";
        }
//        System.out.println(Arrays.toString(test));

        return "redirect:show";
    }

    @GetMapping("/test")
    public String sprintTestShow(@RequestParam int[] test, Model model) {
//        System.out.println(Arrays.toString(test));

        model.addAttribute("sprintUnits", generateSprintList(test, ruEngService.findAll()));
        return "test";
    }


    private List<SprintTask> generateSprintList(int[] unitPos, List<RuEngTranslation> list) {
        List<SprintTask> newList = new ArrayList<>();

        for (int i = 0; i < unitPos.length; i++) {
            Random random = new Random();

            RuEngTranslation unit =  ruEngService.findById(unitPos[i]).orElseThrow();
            String textToTranslate = unit.getOriginText();

            String translationOption = list.get(random.nextInt(0, list.size())).getTranslatedText();


            boolean isCorrect = unit.getTranslatedText().equals(translationOption);
            newList.add(new SprintTask(i, textToTranslate, translationOption, isCorrect));
        }
        System.out.println(newList);

        return newList;
    }

}
