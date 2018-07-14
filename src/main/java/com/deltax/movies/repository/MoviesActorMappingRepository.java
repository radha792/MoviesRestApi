package com.deltax.movies.repository;

import com.deltax.movies.entity.MovieActorMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface MoviesActorMappingRepository extends JpaRepository<MovieActorMapping, Long> {
    @Query("select mam.actorId from MovieActorMapping mam where mam.movieId=:movieId")
    public Long[] findActorsByMovieId(@Param("movieId") Long movieId);
}
