package com.deltax.movies.serviceImpl;

import com.deltax.movies.entity.Actors;
import com.deltax.movies.entity.Movies;
import com.deltax.movies.entity.Producers;
import com.deltax.movies.models.AllMoviesResponse;
import com.deltax.movies.models.MoviesResponse;
import com.deltax.movies.repository.ActorsRepository;
import com.deltax.movies.repository.MoviesActorMappingRepository;
import com.deltax.movies.repository.MoviesRepository;
import com.deltax.movies.repository.ProducersRepository;
import com.deltax.movies.service.GetAllMovies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllMoviesImpl implements GetAllMovies {
    @Autowired
    private MoviesRepository moviesRepository;
    @Autowired
    private ProducersRepository producersRepository;
    @Autowired
    private MoviesActorMappingRepository moviesActorMappingRepository;
    @Autowired
    private ActorsRepository actorsRepository;

    @Override
    public AllMoviesResponse getAllMovies(){
        List<Movies> moviesList=moviesRepository.getAllMovies();
        ArrayList<MoviesResponse> moviesResponseArrayList=new ArrayList<MoviesResponse>();
        moviesList.forEach(sus->{
            MoviesResponse moviesResponse=new MoviesResponse();
            moviesResponse.setName(sus.getName());
            moviesResponse.setYearOfRelease(sus.getYearOfRelease());
            String producerId=sus.getProducerId();
            List<String> actorNameList=new ArrayList<>();
            Long movieId=sus.getId();
            Producers producers=producersRepository.findOne(Long.parseLong(producerId));
            Long[] actorList=moviesActorMappingRepository.findActorsByMovieId(movieId);
            if(actorList.length==0){
                System.out.println("actor is not avail");
            }
            for(int i=0;i<actorList.length;i++){
                Actors actors=actorsRepository.findOne(actorList[i]);
                String actorName= actors.getName();
                System.out.println("actor name is"+actorName);
                actorNameList.add(actorName);
            }
            //Producers producers=producersRepository.findById(Long.parseLong(producerId));
            moviesResponse.setProducerName(producers.getName());
            moviesResponse.setActors(actorNameList);
            moviesResponseArrayList.add(moviesResponse);
        });

        AllMoviesResponse allMoviesResponse=new AllMoviesResponse();
        allMoviesResponse.setMoviesResponseList(moviesResponseArrayList);
        return allMoviesResponse;

    }
}
