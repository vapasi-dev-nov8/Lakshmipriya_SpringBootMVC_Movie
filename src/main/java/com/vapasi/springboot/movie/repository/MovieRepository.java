package com.vapasi.springboot.movie.repository;

import com.vapasi.springboot.movie.Entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {

}
