package com.deltax.movies.repository;

import com.deltax.movies.entity.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ActorsRepository extends JpaRepository<Actors, Long> {
}
