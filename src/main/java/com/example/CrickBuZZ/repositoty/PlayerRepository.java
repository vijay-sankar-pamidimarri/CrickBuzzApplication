package com.example.CrickBuZZ.repositoty;

import com.example.CrickBuZZ.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

    List<Player> findByTeam_NameOfTeam(String teamName);
}
