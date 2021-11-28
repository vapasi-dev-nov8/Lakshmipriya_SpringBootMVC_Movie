package com.vapasi.springboot.movie.service;

import com.vapasi.springboot.movie.Entity.MovieEntity;
import com.vapasi.springboot.movie.dto.MovieDto;
import com.vapasi.springboot.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAllMovies() {
        List<MovieDto> movieList= new ArrayList();

        for (MovieEntity movieEntity : movieRepository.findAll()) {
            movieList.add(MovieDto.dtoFrom(movieEntity));
        }
        return movieList;
    }

    public MovieDto createMovie(MovieDto movieDtoToCreate) {

        MovieEntity movieEntity = MovieEntity.entityFrom(movieDtoToCreate);
        MovieEntity createdMovieEntity = movieRepository.save(movieEntity);
        return MovieDto.dtoFrom(createdMovieEntity);


    }
}
