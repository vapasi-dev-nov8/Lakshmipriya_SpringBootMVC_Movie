package com.vapasi.springboot.movie.dto;

import com.vapasi.springboot.movie.Entity.MovieEntity;

public class MovieDto {
    private int id;
    private String name;
    private String directorName;
    private String actorName;

    public MovieDto(int id, String name, String directorName, String actorName) {
        this.id = id;
        this.name = name;
        this.directorName = directorName;
        this.actorName = actorName;
    }
    public static MovieDto dtoFrom(MovieEntity movieEntity) {
        return new MovieDto(
                movieEntity.getId(),
                movieEntity.getName(),
                movieEntity.getActorName(),
                movieEntity.getDirectorName());
    }
    public String getName() {
        return name;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getActorName() {
        return actorName;
    }

    public int getId() {
        return id;
    }
}
