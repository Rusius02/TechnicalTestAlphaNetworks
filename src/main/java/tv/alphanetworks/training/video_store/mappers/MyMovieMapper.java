package tv.alphanetworks.training.video_store.mappers;

import tv.alphanetworks.training.video_store.dtos.MovieDto;
import tv.alphanetworks.training.video_store.model.*;

import java.util.ArrayList;
import java.util.List;

public class MyMovieMapper {
    public static MovieDto toDto(Movie movie) {
        if (movie == null) {
            return null;
        }

        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setReleaseDate(movie.getReleaseDate());
        movieDto.setLanguage(movie.getLanguage().name());
        if (movie.getCategory() != null) {
            movieDto.setCategory(movie.getCategory().getCategory().toString());
        }

        if (movie instanceof DVD) {
            movieDto.setType("DVD");
            movieDto.setNumberDiscs(((DVD) movie).getNumberDiscs());
        } else if (movie instanceof VHS) {
            movieDto.setType("VHS");
            movieDto.setFormat(((VHS) movie).getFormat().name());
        }

        return movieDto;
    }

    public static Movie toEntity(MovieDto movieDto) {
        if (movieDto == null) {
            return null;
        }

        Movie movie;
        if ("DVD".equalsIgnoreCase(movieDto.getType())) {
            DVD dvd = new DVD();
            dvd.setNumberDiscs(movieDto.getNumberDiscs());
            movie = dvd;
        } else if ("VHS".equalsIgnoreCase(movieDto.getType())) {
            VHS vhs = new VHS();
            vhs.setFormat(Format.valueOf(movieDto.getFormat()));
            movie = vhs;
        } else {
            throw new IllegalArgumentException("Invalid movie type specified");
        }

        movie.setId(movieDto.getId());
        movie.setTitle(movieDto.getTitle());
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setLanguage(Language.valueOf(movieDto.getLanguage()));

        return movie;
    }

    public static List<MovieDto> toListDto(List<Movie> movies) {
        if (movies == null) {
            return null;
        }
        List<MovieDto> movieDtos = new ArrayList<>();
        for (Movie movie : movies) {
            movieDtos.add(toDto(movie));
        }
        return movieDtos;
    }

    public static List<Movie> toEntityList(List<MovieDto> movieDtos) {
        if (movieDtos == null) {
            return null;
        }
        List<Movie> movies = new ArrayList<>();
        for (MovieDto movieDto : movieDtos) {
            movies.add(toEntity(movieDto));
        }
        return movies;
    }
}
