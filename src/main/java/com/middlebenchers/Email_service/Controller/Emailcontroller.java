package com.middlebenchers.Email_service.Controller;


import com.middlebenchers.Email_service.service.Emailgenarator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class Emailcontroller {



    @Autowired
    private Emailgenarator service;




    @PostMapping("/send")
    public ResponseEntity<String>sending(@RequestParam String to,
                                         @RequestParam String subject,
                                         @RequestParam String body){

     return service.send(to,subject,body);

    }

}
