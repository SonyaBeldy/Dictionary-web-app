package ru.sonyabeldy.dictionary.dictionarywebapp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.sonyabeldy.dictionary.dictionarywebapp.models.RuEngTranslation;
import ru.sonyabeldy.dictionary.dictionarywebapp.models.SprintTask;
import ru.sonyabeldy.dictionary.dictionarywebapp.services.RuEngService;
import security.PersonDetails;

import java.util.*;

@Controller
@RequestMapping("/dictionary")
public class RuEngTranslationsController {

    private final RuEngService ruEngService;

    public RuEngTranslationsController(RuEngService service) {
        this.ruEngService = service;
    }

    @GetMapping()
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
//        model.addAttribute("translations", ruEngService.findAll());
        model.addAttribute("translations", ruEngService.findAllByOwner(personDetails.getPerson()));
        return "show";
    }


//    @PostMapping("/test")
//    public String get(@RequestParam(value="test", required = false) int[] test, RedirectAttributes redirectAttributes) {
//        if(test != null) {
//            redirectAttributes.addAttribute("test", test);
//            return "redirect:test";
//        }
////        System.out.println(Arrays.toString(test));
//
//        return "redirect:show";
//    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, params = "delete")
    public String delete(@RequestParam(value = "test", required = false) int[] test, RedirectAttributes redirectAttributes) {
        System.out.println("POST DELETE");
        ruEngService.remove(test);
        return "redirect:show";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, params = "train")
    public String test(@RequestParam(value = "test", required = false) int[] test, RedirectAttributes redirectAttributes) {
        if(test != null) {
            redirectAttributes.addAttribute("test", test);
            return "redirect:test";
        }
        return "redirect:show";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, params = "add")
    public String add(RedirectAttributes redirectAttributes) {
        System.out.println("ADD");
        return "redirect:show";
    }


    @GetMapping("/test")
    public String sprintTestShow(@RequestParam int[] test, Model model) {
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
