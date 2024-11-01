package com.example.CrickBuZZ.Services;

import com.example.CrickBuZZ.Converter.PlayerDtoConverter;
import com.example.CrickBuZZ.model.Player;
import com.example.CrickBuZZ.model.Team;
import com.example.CrickBuZZ.repositoty.PlayerRepository;
import com.example.CrickBuZZ.repositoty.TeamRepository;
import com.example.CrickBuZZ.requestdto.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServices {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public String addplayer(PlayerDto playerDto) {
        Player player= PlayerDtoConverter.playerConverter(playerDto);
         playerRepository.save(player);
         return "Saved";
    }

    public Optional<Player> getplay(int playerid) {
        Optional<Player> player=playerRepository.findById(playerid);
        if(player.isEmpty()){
            throw new RuntimeException();
        }
        return player;
    }

    public void sendEmail(PlayerDto playerDto) {
        SimpleMailMessage mail=new SimpleMailMessage();
        mail.setSubject("Your Registration Sucessfully Completed");
        mail.setText("Hi "+playerDto.getName()+" your Registration Completed  As a"+playerDto.getPlayerGame()+" Hope You Fine");
        mail.setFrom("springprojectcrickbuzz@gmail.com");
        mail.setTo(playerDto.getEmail());
        javaMailSender.send(mail);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getAllWithTheNameOfTeam(String teamName) {

        return playerRepository.findByTeam_NameOfTeam(teamName);
    }

    public List<Player> getPagenation(int pageNo, int pageSize) {
        Page<Player> palyerpage=playerRepository.findAll(PageRequest.of(1,4,Sort.by("name").ascending()));
        List<Player> list=new LinkedList<>();
        for(Player player:palyerpage){
            list.add(player);
        }
        return list;
    }
}
