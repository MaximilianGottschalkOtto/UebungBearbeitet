package com.example.uebung;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController()
public class CustomerController {

    private final CustomerRepository peopleRepository;

    public CustomerController(CustomerRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    //This methode shows all keys and all BodyRequests
    @GetMapping("/getAll")
    public List<Customer> index() {
        return peopleRepository.findAll();
    }

    //With this methode you can save the Key and the RequestBody.
    @PutMapping("/map/{key}")
    public Customer saveKeyAndBody(@RequestBody Customer people, @PathVariable("key") String key) {
        people.setKey(key);
        return peopleRepository.save(people);
    }

    //This methode shows the Body, if you know the key.
    @GetMapping("/map/{key}")
    public Optional<Customer> getKey(@PathVariable String key) {
        return peopleRepository.findById(key);
    }

    //This methode shows all keys.
    @GetMapping("/map")
    public ArrayList<String> getAllKeys(){

        List<Customer> peopleListWithKeysAndPeople = peopleRepository.findAll();
        ArrayList<String> saveKeys = new ArrayList<>();

        for (Customer keys: peopleListWithKeysAndPeople) {
            saveKeys.add(keys.getKey());
        }

        return saveKeys;
    }


    



}
