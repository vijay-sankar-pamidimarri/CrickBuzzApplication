package com.example.CrickBuZZ.repositoty;

import com.example.CrickBuZZ.model.match1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<match1,Integer> {
}
