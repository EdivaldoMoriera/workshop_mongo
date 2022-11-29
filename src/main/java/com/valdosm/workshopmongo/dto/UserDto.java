package com.valdosm.workshopmongo.dto;

import com.valdosm.workshopmongo.domain.User;

public class UserDto {
    private String id;
    private String name;
    
        public UserDto( User obj){
        id = obj.getId();
        name = obj.getName();

    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
   
    
    
}
