package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Bid;

public interface BidRepo extends JpaRepository<Bid, Integer>{

}
