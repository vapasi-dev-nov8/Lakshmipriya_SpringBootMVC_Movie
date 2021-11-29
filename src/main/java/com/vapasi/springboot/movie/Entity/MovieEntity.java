package com.vapasi.springboot.movie.Entity;

import com.vapasi.springboot.movie.dto.MovieDto;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="movies")
public class MovieEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String directorName;
    private String actorName;

    public MovieEntity() {
    }

    public MovieEntity(Integer id, String name, String directorName, String actorName) {
        this.id = id;
        this.name = name;
        this.directorName = directorName;
        this.actorName = actorName;
    }

    public static MovieEntity entityFrom(MovieDto movieDto) {
        return new MovieEntity(movieDto.getId(), movieDto.getName(),  movieDto.getDirectorName() , movieDto.getActorName());
    }

    public MovieDto toMovieDto() {
        return new MovieDto(this.id, this.name,  this.directorName , this.actorName);
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directorName='" + directorName + '\'' +
                ", actorName='" + actorName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return id.equals(that.id) && name.equals(that.name) && directorName.equals(that.directorName) && actorName.equals(that.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, directorName, actorName);
    }

    public Integer getId() {
        return id;
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
}
