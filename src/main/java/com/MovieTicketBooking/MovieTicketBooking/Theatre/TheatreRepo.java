package com.MovieTicketBooking.MovieTicketBooking.Theatre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheatreRepo extends JpaRepository<TheatreModel,Integer> {
    Optional<TheatreModel> findByEmailAndPassword(String email, String password);

    List<TheatreModel> findByTheatreId(Integer theatreId);
}
