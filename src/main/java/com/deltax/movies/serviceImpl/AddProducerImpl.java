package com.deltax.movies.serviceImpl;

import com.deltax.movies.entity.Producers;
import com.deltax.movies.models.ProducerRequest;
import com.deltax.movies.repository.ProducersRepository;
import com.deltax.movies.service.AddProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AddProducerImpl implements AddProducer{
    @Autowired
    private ProducersRepository producersRepository;

    @Override
    public void addProducer(ProducerRequest producerRequest){
        Producers producers=new Producers();
        producers.setName(producerRequest.getName());
        producers.setSex(producerRequest.getSex());
        producers.setBio(producerRequest.getBio());
        Date dateOfBirth=new Date();
        try {
            if(producerRequest.getDob()!=null) {
                dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(producerRequest.getDob());
            }else{
                dateOfBirth=null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        producers.setDob(dateOfBirth);
        try{
            producersRepository.saveAndFlush(producers);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
