package com.example.CrickBuZZ.Converter;

import com.example.CrickBuZZ.model.Player;
import com.example.CrickBuZZ.requestdto.PlayerDto;

public class PlayerDtoConverter {
  public static Player playerConverter(PlayerDto playerDto) {
    Player player = new Player();
    player.setId(playerDto.getId());
    player.setName(playerDto.getName());
    player.setGender(playerDto.getGender());
    player.setAge(playerDto.getAge());
    player.setContry(playerDto.getCountry());
    player.setGoodName(playerDto.getGoodName()); // Ensure this field is also mapped
    player.setWeight(playerDto.getWeight());
    player.setEmail(playerDto.getEmail());// Ensure this field is also mapped
    return player;
}
}
