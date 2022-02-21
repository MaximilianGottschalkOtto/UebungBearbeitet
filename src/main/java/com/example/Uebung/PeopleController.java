package com.example.Uebung;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.Period;
import java.util.*;

@RestController()
public class PeopleController {

    private final PeopleRepository peopleRepository;

    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    //This methode shows all keys and all BodyRequests
    @GetMapping("/getAll")
    public List<People> index() {
        return peopleRepository.findAll();
    }

    //With this methode you can save the Key and the RequestBody.
    @PutMapping("/map/{key}")
    public People saveKeyAndBody(@RequestBody People people, @PathVariable("key") String key) {
        people.setKey(key);
        return peopleRepository.save(people);
    }

    //This methode shows the Body, if you know the key.
    @GetMapping("/map/{key}")
    public Optional<People> getKey(@PathVariable String key) {
        return peopleRepository.findById(key);
    }

    //This methode shows all keys.
    @GetMapping("/map")
    public ArrayList<String> getAllKeys(){

        List<People> peopleListWithKeysAndPeople = peopleRepository.findAll();
        ArrayList<String> saveKeys = new ArrayList<>();

        for (People keys: peopleListWithKeysAndPeople) {
            saveKeys.add(keys.getKey());
        }

        return saveKeys;
    }


    



}
