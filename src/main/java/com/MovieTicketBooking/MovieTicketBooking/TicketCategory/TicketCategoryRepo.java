package com.MovieTicketBooking.MovieTicketBooking.TicketCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketCategoryRepo extends JpaRepository<TicketCategoryModel,Integer> {

}
