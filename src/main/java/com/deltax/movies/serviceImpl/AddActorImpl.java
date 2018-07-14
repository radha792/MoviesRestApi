package com.deltax.movies.serviceImpl;

import com.deltax.movies.entity.Actors;
import com.deltax.movies.models.ActorRequest;
import com.deltax.movies.repository.ActorsRepository;
import com.deltax.movies.service.AddActor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AddActorImpl implements AddActor{
    @Autowired
    private ActorsRepository actorsRepository;

    @Override
    public void addActor(ActorRequest actorRequest){
        Actors actors=new Actors();
        actors.setName(actorRequest.getName());
        actors.setSex(actorRequest.getSex());
        actors.setBio(actorRequest.getBio());
        Date dateOfBirth=new Date();
        try {
            if(actorRequest.getDob()!=null) {
                dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(actorRequest.getDob());
            }else{
                dateOfBirth=null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        actors.setDob(dateOfBirth);
        try{
            actorsRepository.saveAndFlush(actors);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
