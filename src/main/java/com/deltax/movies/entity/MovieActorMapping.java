package com.deltax.movies.entity;

import javax.persistence.*;

@Entity
@Table(name = "movie_actor_mapping")
public class MovieActorMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "movie_id")
    private long movieId;

    @Column(name = "actor_id")
    private long actorId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }
}
