package com.example.CrickBuZZ.mailSende;

import com.example.CrickBuZZ.model.Player;
import com.example.CrickBuZZ.model.Team;
import com.example.CrickBuZZ.model.match1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class customMailSender {
    @Autowired
    JavaMailSender javaMailSender;
    public void mail(Player player, match1 match, Team oppositeTeam,Team currentTeam){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("springprojectcrickbuzz@gmail.com");
// Set up the email subject
simpleMailMessage.setSubject("Match Notification: " + match.getMatchName() + " - " + currentTeam.getNameOfTeam() + " vs " + oppositeTeam.getNameOfTeam());

// Create the email body
String emailBody = "Dear Team,\n\n" +
    "This is a reminder from BCCI official regarding the upcoming match: " + match.getMatchName() + ".\n\n" +
    "Your team will be facing " + oppositeTeam.getNameOfTeam()+ ".\n\n" +
    "Please be ready for the match.\n\n" +
    "Thank you,\n" +
    "BCCI Official";

// Set the email body
simpleMailMessage.setText(emailBody);
simpleMailMessage.setTo(player.getEmail());
javaMailSender.send(simpleMailMessage);

    }
}
