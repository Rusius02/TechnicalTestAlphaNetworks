package tv.alphanetworks.training.video_store.services;

import tv.alphanetworks.training.video_store.dtos.MovieDto;

import java.util.List;

public interface MovieService {
    List<MovieDto> getAll();
    MovieDto getById(Long id);
    MovieDto register(MovieDto movieDto);
    List<MovieDto> getByName(String name);
    List<MovieDto> getAllDVDs();
    List<MovieDto> getAllVHS();
    List<MovieDto> getDuplicateMovies();
    List<MovieDto> getAvailableDuplicateMovies();
}
