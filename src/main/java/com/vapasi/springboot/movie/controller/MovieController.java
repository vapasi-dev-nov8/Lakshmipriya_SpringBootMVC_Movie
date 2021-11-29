package com.vapasi.springboot.movie.controller;

import com.vapasi.springboot.movie.Entity.MovieEntity;
import com.vapasi.springboot.movie.dto.MovieDto;
import com.vapasi.springboot.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public ResponseEntity<List<MovieDto>> getAllMovies()
    {
        List<MovieDto> movieDtoList = movieService.getAllMovies();
        return ResponseEntity.ok().body(movieDtoList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieForId(@PathVariable Integer id) {
        Optional<MovieDto> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok().body(movie.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/searchByActor")
    public ResponseEntity<List<MovieDto>> getAllMoviesByActorNames(@RequestParam(value="actorName") String actorName) {
        List<MovieDto> movieList;
        movieList = movieService.getAllMovieListByActorNames(actorName);
        return ResponseEntity.ok().body(movieList);
    }

    @PostMapping("/")
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDtoToCreate)
    {
        MovieDto savedMovie = movieService.createMovie(movieDtoToCreate);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<MovieDto> updateMovie( @RequestBody MovieDto movieDtoToUpdate)
    {

      //  Optional<MovieDto> movie = movieService.getMovieById(id);
        //        MovieDto updatedMovie = movieService.updateMovie(movie.get());

        MovieDto updatedMovie = movieService.updateMovie(movieDtoToUpdate);

        return new ResponseEntity<>(updatedMovie, HttpStatus.CREATED);

    }

}
