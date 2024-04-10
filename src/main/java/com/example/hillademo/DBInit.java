package com.example.hillademo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements ApplicationRunner {

    private final ContactRepository repository;

    public DBInit(ContactRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // generate 10 random first and last names
        String[] firstNames = {"John", "Jane", "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hank"};
        String[] lastNames = {"Smith", "Doe", "Johnson", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson"};

        // use the names to generate 100 random contacts and save them
        for (int i = 0; i < 100; i++) {
            String name = firstNames[(int) (Math.random() * 10)] + " " + lastNames[(int) (Math.random() * 10)];
            String email = name.replaceAll(" ", "").toLowerCase() + "@example.com";
            String phone = "555-555-5555";
            repository.save(new Contact(name, email, phone));
        }
    }
}
