package com.example.CrickBuZZ.Services;

import com.example.CrickBuZZ.Converter.TeamConverter;
import com.example.CrickBuZZ.model.Player;
import com.example.CrickBuZZ.model.Team;
import com.example.CrickBuZZ.repositoty.PlayerRepository;
import com.example.CrickBuZZ.repositoty.TeamRepository;
import com.example.CrickBuZZ.requestdto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServices {
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    PlayerRepository playerRepository;
    public Team getTeam() {
        Optional<Team> team=teamRepository.findById(0);
        if(team.isEmpty()){
            throw  new RuntimeException();
        }
        else{
            return team.get();
        }
    }


    public Team addTeam(TeamDto teamDto) {
       return teamRepository.save(TeamConverter.TeamConverterdto(teamDto));
    }

    public Team addplayers(int team_id,int player_id){
        Optional<Team> team=teamRepository.findById(team_id);
        Optional<Player> player=playerRepository.findById(player_id);
        if(team.isEmpty()||player.isEmpty()){
            throw new RuntimeException("Details Not Found Re-CheckAgain");
        }

        List<Player> players = team.get().getPlayers();
        players.add(player.get());
        team.get().setPlayers(players);
        team.get().setPlayers(players);
        player.get().setTeam(team.get());
        teamRepository.save(team.get());
        playerRepository.save(player.get());
        return team.get();

    }
}
