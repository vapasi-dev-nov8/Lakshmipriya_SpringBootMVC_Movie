package com.vapasi.springboot.movie.controller;

import com.vapasi.springboot.movie.dto.MovieDto;
import com.vapasi.springboot.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/")
    public ResponseEntity<MovieDto> saveMovie(@RequestBody MovieDto movieDtoToCreate)
    {
        MovieDto savedMovie = movieService.createMovie(movieDtoToCreate);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }
}
