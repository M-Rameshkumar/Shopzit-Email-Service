package com.middlebenchers.Email_service.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class Emailgenarator {

    private JavaMailSender javaMailSender;

    public Emailgenarator(JavaMailSender javaMailSender) {

        this.javaMailSender = javaMailSender;
    }



  public ResponseEntity<String> send(String to , String subject , String body){

        new Thread(()->{


        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);


            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body,true);

            javaMailSender.send(message);
            System.out.println("sucessfully email sented");
        }
        catch (MessagingException e){

            System.out.println("ERROR WHILE SENDING EMAIL TO CUSTOMER");
        }
        }).start();

        return  new ResponseEntity<>("sucessfully email sented", HttpStatus.CREATED);
  }


}
