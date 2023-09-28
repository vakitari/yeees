package com.example.demo.controller;

import com.example.demo.Entity.History;
import com.example.demo.Entity.User;
import com.example.demo.Service.HistorySerivce;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/history")
public class HistoryController {
    private final HistorySerivce service;
    private HistoryController(HistorySerivce serivce){this.service = serivce;}

@PostMapping("/add")
    public String addHistory(@ModelAttribute History history){
    service.save(history);
      return "redirect:/api/history/all";
    }
    @GetMapping("/all")
    public String allHis(Model model){
        model.addAttribute("histories", service.getAll());
        model.addAttribute("history",new History());
        return"history";
    }

    @GetMapping("/del")
    public String del(@RequestParam Long  id){
        service.del(id);
        return "redirect:/history/all";}
}
