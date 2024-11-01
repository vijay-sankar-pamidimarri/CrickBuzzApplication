package com.example.CrickBuZZ.repositoty;

import com.example.CrickBuZZ.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends JpaRepository<Team,Integer> {

   @Query(value = " select distinct * from team where name_of_team=:nameOfTeamB limit 1",nativeQuery = true)
   public Team findByNameOfTeamcustom(@Param("nameOfTeamB") String nameOfTeamB);
}
