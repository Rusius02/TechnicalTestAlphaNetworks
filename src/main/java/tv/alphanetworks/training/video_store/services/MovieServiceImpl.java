package tv.alphanetworks.training.video_store.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tv.alphanetworks.training.video_store.dtos.MovieDto;
import tv.alphanetworks.training.video_store.mappers.MyMovieMapper;
import tv.alphanetworks.training.video_store.model.*;
import tv.alphanetworks.training.video_store.repository.CategoryRepository;
import tv.alphanetworks.training.video_store.repository.MovieRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl  implements MovieService{

    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;
    //private final IMovieMapper movieMapper;


    @Override
    public List<MovieDto> getAll() {
        List<Movie> movies = this.movieRepository.findAll();
        return MyMovieMapper.toListDto(movies);
    }
    @Override
    public MovieDto getById(Long id) {
        Movie movie = this.movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Movie not found"));
        return MyMovieMapper.toDto(movie);
    }
    @Override
    public MovieDto register(MovieDto movieDto) {
        Movie movie;
        if ("DVD".equalsIgnoreCase(movieDto.getType())) {
            movie = new DVD();
            ((DVD) movie).setNumberDiscs(movieDto.getNumberDiscs());
        } else if ("VHS".equalsIgnoreCase(movieDto.getType())) {
            movie = new VHS();
            ((VHS) movie).setFormat(Format.valueOf(movieDto.getFormat()));
        } else {
            throw new IllegalArgumentException("Invalid movie type specified");
        }

        movie.setTitle(movieDto.getTitle());
        movie.setCategory(findCategoryByName(movieDto.getCategory()));
        movie.setReleaseDate(movieDto.getReleaseDate());
        movie.setLanguage(Language.valueOf(movieDto.getLanguage()));

        Movie savedMovie = this.movieRepository.save(movie);
        return MyMovieMapper.toDto(savedMovie);
    }
    private Category findCategoryByName(String categoryName) {
        return categoryRepository.findByCategory(CategoryEnum.valueOf(categoryName))
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
    @Override
    public List<MovieDto> getByTitle(String title) {
        List<Movie> movies =  this.movieRepository.findByTitle(title);
        return MyMovieMapper.toListDto(movies);
    }

    @Override
    public List<MovieDto> getAllDVDs() {
        List<Movie> dvds = movieRepository.findAllByTypeDVD();
        return MyMovieMapper.toListDto(dvds);
    }

    @Override
    public List<MovieDto> getAllVHS() {
        List<Movie> vhs = movieRepository.findAllByTypeVHS();
        return MyMovieMapper.toListDto(vhs);
    }

    @Override
    public List<MovieDto> getDuplicateMovies() {
        List<Object[]> duplicates = movieRepository.findDuplicateMovies();
        List<MovieDto> duplicateMovies = new ArrayList<>();

        for (Object[] duplicate : duplicates) {
            String title = (String) duplicate[0];
            LocalDateTime releaseDate = (LocalDateTime) duplicate[1];
            List<Movie> movies = movieRepository.findByTitleAndReleaseDate(title, releaseDate);
            duplicateMovies.addAll(MyMovieMapper.toListDto(movies));
        }

        return duplicateMovies;
    }

    @Override
    public List<MovieDto> getAvailableDuplicateMovies() {
        List<Object[]> duplicates = movieRepository.findAvailableDuplicateMovies();
        List<MovieDto> availableDuplicateMovies = new ArrayList<>();

        for (Object[] duplicate : duplicates) {
            String title = (String) duplicate[0];
            LocalDateTime releaseDate = (LocalDateTime) duplicate[1];
            List<Movie> availableMovies = movieRepository.findAvailableByTitleAndReleaseDate(title, releaseDate);
            availableDuplicateMovies.addAll(MyMovieMapper.toListDto(availableMovies));
        }

        return availableDuplicateMovies;
    }
}
