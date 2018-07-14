package com.deltax.movies.serviceImpl;

import com.deltax.movies.entity.MovieActorMapping;
import com.deltax.movies.entity.Movies;
import com.deltax.movies.models.AddMovieRequest;
import com.deltax.movies.repository.MoviesActorMappingRepository;
import com.deltax.movies.repository.MoviesRepository;
import com.deltax.movies.service.AddNewMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNewMovieImpl implements AddNewMovie{
    @Autowired
    private MoviesRepository moviesRepository;
    @Autowired
    private MoviesActorMappingRepository moviesActorMappingRepository;

    @Override
    public void addNewMovies(AddMovieRequest addMovieRequest){
        Movies movies=new Movies();
        movies.setName(addMovieRequest.getName());
        movies.setPlot(addMovieRequest.getPlot());
        movies.setPosterUrl(addMovieRequest.getPosterUrl());
        movies.setYearOfRelease(addMovieRequest.getYearOfRelease());
        movies.setProducerId(addMovieRequest.getProducerId());

        try{
            moviesRepository.saveAndFlush(movies);
        }catch (Exception e){
            e.printStackTrace();
        }
        long movieId=movies.getId();

        MovieActorMapping movieActorMapping=new MovieActorMapping();
        for(int i=0;i<addMovieRequest.getActorsId().size();i++){
            movieActorMapping.setMovieId(movieId);
            movieActorMapping.setActorId(addMovieRequest.getActorsId().get(i));
        }
        try{
            moviesActorMappingRepository.saveAndFlush(movieActorMapping);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
