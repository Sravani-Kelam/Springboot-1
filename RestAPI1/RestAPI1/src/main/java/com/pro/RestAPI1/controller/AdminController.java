package com.pro.RestAPI1.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    //lh:8081/admin/-admin root req
   // @GetMapping("/")
    //public String getDetails(){
        //return "Good Afternoon";
    //lh:8081/admin/users/101
    @GetMapping("/users/{uid}")
    public String getUserId(@PathVariable String uid){

        return  "User Id"+uid;
    }
    //lh:8081/admin/users/?uname=sri
    //@GetMapping("/users/")
   // public String getUserName(@RequestParam("uname")String name){
      //  return "User Name:"+name;
        @PostMapping("/users/")
                public String getToken(@RequestHeader(defaultValue = "GN")String tokenvalue){
            return "Token Value:" +tokenvalue;
        }
    }

