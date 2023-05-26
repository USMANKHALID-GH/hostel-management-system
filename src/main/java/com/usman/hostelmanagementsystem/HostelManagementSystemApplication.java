package com.usman.hostelmanagementsystem;


import com.twilio.Twilio;
import com.usman.hostelmanagementsystem.config.TwilioConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HostelManagementSystemApplication {
    @Autowired
    private TwilioConfig twilioConfig;

    @PostConstruct
    public  void initTwilio(){
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());

    }

    public static void main(String[] args) {
        SpringApplication.run(HostelManagementSystemApplication.class, args);
    }

}
