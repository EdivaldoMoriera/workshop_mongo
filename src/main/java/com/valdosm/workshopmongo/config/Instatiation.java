package com.valdosm.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.valdosm.workshopmongo.domain.User;
import com.valdosm.workshopmongo.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        User maria = new User("1", "Pedro", "pedro@gmail.com");
        User lucas = new User("2", "Lucas", "lucas@gmail.com");
        User marta = new User("3", "Marta", "martao@gmail.com");

        repository.saveAll(Arrays.asList(maria, lucas, marta));

    }

}
