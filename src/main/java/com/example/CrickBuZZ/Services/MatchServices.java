package com.example.CrickBuZZ.Services;

import com.example.CrickBuZZ.Converter.MatchConverter;
import com.example.CrickBuZZ.mailSende.customMailSender;
import com.example.CrickBuZZ.model.Player;
import com.example.CrickBuZZ.model.Team;
import com.example.CrickBuZZ.model.match1;
import com.example.CrickBuZZ.repositoty.MatchRepository;
import com.example.CrickBuZZ.repositoty.TeamRepository;
import com.example.CrickBuZZ.requestdto.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServices {
 @Autowired
 customMailSender mailSender;
    @Autowired
    MatchRepository matchRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    PlayerServices playerServices;

    public match1 addMatch(MatchDto matchDto) {
        match1 match= MatchConverter.match1Converter(matchDto);
        return matchRepository.save(match);
    }

    public match1 getMatc() {
       Optional<match1>c1= matchRepository.findById(1);
       if(c1.isEmpty()){
           throw  new RuntimeException("No details are found");
       }
       return c1.get();
    }

    public String addMatches(MatchDto matchDto, String nameOfTeamA, String nameOfTeamB) {
        match1 match=MatchConverter.match1Converter(matchDto);
        List<Team> list=new ArrayList<>();
        Team TeamA= (Team) teamRepository.findByNameOfTeamcustom(nameOfTeamA);
        Team TeamB= (Team) teamRepository.findByNameOfTeamcustom(nameOfTeamB);
        List<Player> Team_A=playerServices.getAllWithTheNameOfTeam(nameOfTeamA);
        List<Player> Team_B=playerServices.getAllWithTheNameOfTeam(nameOfTeamB);

        list.add(TeamA);
        list.add(TeamB);
        match.setTeam(list);
        for(Player player:Team_A){
           if(player.getEmail()!=null){
               mailSender.mail(player,match,TeamA,TeamB);
           }
        }
        for(Player player:Team_B){
           if(player.getEmail()!=null){
               mailSender.mail(player,match,TeamB,TeamA);
           }
        }
        matchRepository.save(match);
        return "SucessFully Made The Mathces";

    }
}
