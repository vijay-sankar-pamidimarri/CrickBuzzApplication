package com.example.CrickBuZZ.controller;

import com.example.CrickBuZZ.Services.PlayerServices;
import com.example.CrickBuZZ.model.Player;
import com.example.CrickBuZZ.requestdto.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/v1/player")
public class PlayerController {
    @Autowired
    PlayerServices playerServices;
    @PostMapping("/add")
    public ResponseEntity postplayer(@RequestBody PlayerDto playerDto){
        try{
            playerServices.sendEmail(playerDto);
       return new ResponseEntity(playerServices.addplayer(playerDto),HttpStatus.ACCEPTED);

       }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getpalyer(@PathVariable("id") int id) throws RuntimeException{
        try{
            return new ResponseEntity((playerServices.getplay(id)),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage()+" Unable to Fetch",HttpStatus.BAD_REQUEST);
        }
    }
    //for the users to get inforamation of all players
    @GetMapping("crickbuzz/user/allplayers")
    public ResponseEntity getAllPlayers(){
        try{
            return new ResponseEntity(playerServices.getAllPlayers(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    //fetching Details about the all players who from the added country
    @GetMapping("crickbuzz/user/getallplayers")
    public ResponseEntity getAllWithTheNameOfTeam(@RequestParam("TeamName") String TeamName){
        return new ResponseEntity(playerServices.getAllWithTheNameOfTeam(TeamName),HttpStatus.ACCEPTED);
    }
    @GetMapping("crickbuzz/user/pagenation")
    public ResponseEntity getPagenation(@RequestParam int page_no,@RequestParam int page_size){
        return new ResponseEntity(playerServices.getPagenation(page_no,page_size),HttpStatus.ACCEPTED);
    }
}
