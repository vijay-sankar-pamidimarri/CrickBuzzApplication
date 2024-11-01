package com.example.CrickBuZZ.controller;

import com.example.CrickBuZZ.Services.TeamServices;
import com.example.CrickBuZZ.requestdto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/v1/team")
public class TeamController {
    @Autowired
    TeamServices teamServices;
    @PostMapping("/add")
    public ResponseEntity addteam(@RequestBody TeamDto teamDto){
        return new ResponseEntity(teamServices.addTeam(teamDto), HttpStatus.CREATED);
    }
    @PostMapping("/addteam/{team-id}/{player-id}")
    public ResponseEntity addPlayersToTeam(@PathVariable("team-id") int teamid,@PathVariable("player-id") int playerid) throws RuntimeException{
        try{
            return new ResponseEntity(teamServices.addplayers(teamid,playerid),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
