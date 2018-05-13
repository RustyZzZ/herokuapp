package com.example.herokuapp.controller;

import com.example.herokuapp.entity.Guy;
import com.example.herokuapp.service.GuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final GuyService guyService;

    @Autowired
    public MainController(GuyService guyService) {
        this.guyService = guyService;
    }

    @PostMapping("/sendGuy")
    public String sendGuy(@RequestBody String name) {
        Guy guy = new Guy();
        guy.setName(getName(name));
        guy.setPercentage(10d);
        guyService.save(guy);
        return "Saved";
    }

    @GetMapping("/getGay")
    public String getGayGuy() {
        return guyService.getGayGuy()
                         .getName();
    }

    private static String getName(String name) {
        return name.replace("name=", "");
    }
}
