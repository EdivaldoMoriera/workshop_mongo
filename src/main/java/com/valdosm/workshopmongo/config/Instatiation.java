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

        User maria = new User("1", "Pedro", "maria@gmail.com");
        User lucas = new User("2", "Lucas", "lucas@gmail.com");
        User marta = new User("3", "Marta", "marta@gmail.com");
        User camila = new User("4", "Camila", "pedro@gmail.com");
        User joao = new User("5", "João", "joao@gmail.com");
        User andrea = new User("6", "Andrea", "andrea@gmail.com");

        repository.saveAll(Arrays.asList(maria, lucas, marta, camila, joao, andrea));

    }

}
