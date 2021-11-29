package com.vapasi.springboot.movie.repository;

import com.vapasi.springboot.movie.Entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {
    public List<Optional<MovieEntity>> findByActorNameIn(List<String> actorNames);
}
