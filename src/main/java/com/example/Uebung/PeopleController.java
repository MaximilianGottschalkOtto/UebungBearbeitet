package com.example.Uebung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class PeopleController {

    private final PeopleRepository peopleRepository;

    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/getAll")
    public List<People> index() {
        return peopleRepository.findAll();
    }

    @PostMapping("/save")
    public People addPeople(@RequestBody People people) {
        return peopleRepository.save(people);
    }


}
