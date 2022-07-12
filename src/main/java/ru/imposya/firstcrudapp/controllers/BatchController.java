package ru.imposya.firstcrudapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.imposya.firstcrudapp.services.PeopleService;

@Controller
@RequestMapping("/test-batch-update")
public class BatchController {


    private final PeopleService peopleService;

    public BatchController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public String index() {
        return "batch/index";
    }
    /*@GetMapping("/without")
    public String withoutBatch() {
        personDAO.testMultipleUpdate();
        return "redirect:/people";
    }

    @GetMapping("/with")
    public String withBatch() {
        personDAO.testBatchUpdate();
        return "redirect:/people";
    }*/
}
