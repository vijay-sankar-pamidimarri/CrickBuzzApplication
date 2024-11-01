package com.example.CrickBuZZ.controller;

import com.example.CrickBuZZ.Services.MatchServices;
import com.example.CrickBuZZ.model.match1;
import com.example.CrickBuZZ.requestdto.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/v1/match")
public class MatchController {
    @Autowired
    MatchServices matchServices;
    @PostMapping("/add")
    public match1 postMatch(@RequestBody MatchDto matchDto){
        return matchServices.addMatch(matchDto);
    }
    @GetMapping("/get")
    public match1 getMatch() throws RuntimeException{
        try{
          return matchServices.getMatc();
        }catch(Exception e){
            return null;
        }

    }
    @PostMapping("crickbuzz/admin/addMatch")
    public String addMatch(@RequestBody MatchDto matchDto,@RequestParam("nameTeamA") String nameOfTeamA,@RequestParam("nameOfTeamB") String nameOfTeamB){
        return matchServices.addMatches(matchDto,nameOfTeamA,nameOfTeamB);
    }
}
