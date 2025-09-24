package fr.caensup.sio.demo.controllers;

import fr.caensup.sio.demo.models.AppMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("messages")
public class HomeController {

    @GetMapping({"", "/", "/home"})
    public String index() {
        return "home/index";
    }

    @ModelAttribute("messages")
    public List<AppMessage> getMessages() {
        List<AppMessage> list= new ArrayList<>();
        list.add(new AppMessage("Test", "ok", "", ""));
        return new ArrayList<>();
    }

    @GetMapping("/msg/{message}")
    public String displayMessage(@PathVariable String message) {
        return "home/msg";
    }

    @GetMapping("/create")
    public ModelAndView _createForm() {
        ModelAndView mv=new ModelAndView("home/create");
        mv.addObject("title", "Création de message");
        mv.addObject("btnValidateCaption","Créer le message");
        mv.addObject("msg", new AppMessage());
        return mv;
    }

     @PostMapping("/create")
     public RedirectView postMessage(@ModelAttribute AppMessage message, @SessionAttribute("messages")  List<AppMessage> messages, RedirectAttributes attributes) {
        messages.add(message);
        attributes.addFlashAttribute("msg", message);
        return new RedirectView("/");
     }

    @GetMapping("/test/{title}/{icon}/{color}")
    public ModelAndView test(
            @PathVariable String title,
            @PathVariable String icon,
            @PathVariable String color
    ) {
        return new ModelAndView("/home/message","msg",new AppMessage(
                title,
                "",
                icon,
                color
        ));
    }
}