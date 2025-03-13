package com.pro.api1.service;

import com.pro.api1.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList;
    public UserService(){
        userList=new ArrayList<>();
        User user1 =new User(id:101,name:"ajju",age:22,email:"ajju567@gmail.com");
        User user2 =new User(id:102,name:"avi",age:29,email:"avi1678@gmail.com");
        User user3 =new User(id:103,name:"aru",age:26,email:"aru897@gmail.com");
        User user4 =new User(id:104,name:"sri",age:28,email:"sri5678@gmail.com");
        User user5 =new User(id:105,name:"sravs",age:32,email:"sravs826@gmail.com");
        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }

    public Optional<User> getUser(Integer id){
        Optional optional=Optional.empty();
        for (User user: userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
            }
        }
                return optional;
            }
        }
