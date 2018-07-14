package com.deltax.movies.repository;

import com.deltax.movies.entity.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Component
public interface MoviesRepository extends JpaRepository<Movies, Long>{
    @Query(" from Movies movies")
    public List<Movies> getAllMovies();
}
