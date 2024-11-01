package com.example.CrickBuZZ.Converter;

import com.example.CrickBuZZ.model.match1;
import com.example.CrickBuZZ.requestdto.MatchDto;

public class MatchConverter {
    public static match1 match1Converter(MatchDto matchDto){
        match1 match=new match1();
        match.setMatchName(matchDto.getMatchName());
        match.setPlaceofVenue(matchDto.getPlaceofVenue());
        return match;
    }
}
