package com.deltax.movies.repository;

import com.deltax.movies.entity.Producers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface ProducersRepository extends JpaRepository<Producers, Long> {
//    @Query("select producers from Producers producers where producer.id = :id")
//    public Producers findById(@Param("id") Long id);



}
