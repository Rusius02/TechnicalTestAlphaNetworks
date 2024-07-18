package tv.alphanetworks.training.video_store.mappers;

import org.mapstruct.Mapper;
import tv.alphanetworks.training.video_store.dtos.MovieDto;
import tv.alphanetworks.training.video_store.model.Movie;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMovieMapper {

    MovieDto toDto(Movie movie);
    Movie toEntity(MovieDto movieDto);
    List<Movie> toListEntity(List<MovieDto> movieDtos);
    List<MovieDto> toListDto(List<Movie> movies);
}
