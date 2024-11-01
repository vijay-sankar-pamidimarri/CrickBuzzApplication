package com.example.CrickBuZZ.Converter;

import com.example.CrickBuZZ.model.Team;
import com.example.CrickBuZZ.requestdto.TeamDto;

public class TeamConverter {
    public static Team TeamConverterdto(TeamDto teamDto){
        return Team.builder()
                .nameOfTeam(teamDto.getNameOfTeam())
                .History(teamDto.getHistory())
                .Head(teamDto.getHead())
                .build();
    }
}
