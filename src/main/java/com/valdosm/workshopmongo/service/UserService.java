package com.valdosm.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.valdosm.workshopmongo.domain.User;
import com.valdosm.workshopmongo.repository.UserRepository;
import com.valdosm.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> findAll(){
        return repository.findAll();
        
    }
    public Page<User> findPage(Integer page, Integer  linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repository.findAll( pageRequest);
    }
     public User findById(String id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id:" + id+ ", Tipo:" +User.class.getName()));  

    }
    public User insert(User obj){
        return repository.save(obj);

    }
   
    //atualizar
    public User update(Integer id, User obj){
        User entity = repository.getReferenceById(id);
        updateDate(obj, entity);
            return repository.save(entity);

        }     
    private void updateDate(User obj, User entity) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
    }

    
}

