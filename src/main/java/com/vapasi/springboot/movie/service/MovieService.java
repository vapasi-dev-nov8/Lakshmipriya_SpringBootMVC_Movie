package com.vapasi.springboot.movie.service;

import com.vapasi.springboot.movie.Entity.MovieEntity;
import com.vapasi.springboot.movie.dto.MovieDto;
import com.vapasi.springboot.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    public MovieDto updateMovie(MovieDto movieDtoToCreate) {
        MovieEntity movieEntity = MovieEntity.entityFrom(movieDtoToCreate);
        MovieEntity updatedMovieEntity = movieRepository.save(movieEntity);
        return MovieDto.dtoFrom(updatedMovieEntity);
    }
    public Optional<MovieDto> getMovieById(@PathVariable Integer id) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
        return movieEntity.map(MovieDto::dtoFrom);
    }
    public List<MovieDto> getAllMovieListByActorNames(String actorName) {
        System.out.print(actorName +"actorName");
        List<String> actorNames = Arrays.asList(actorName.split(",", -1));
        System.out.print("actorName list size: "+actorNames.size());

        List<MovieDto> movieDtoList = new ArrayList<>();
        List<Optional<MovieEntity>> moviesEntity = movieRepository.findByActorNameIn(actorNames);

        for(Optional<MovieEntity> optionalMovieEntity: moviesEntity){
            MovieEntity movieEntity = (MovieEntity)optionalMovieEntity.get();
            movieDtoList.add(MovieDto.dtoFrom(movieEntity));
        }
        return movieDtoList;
    }

}
