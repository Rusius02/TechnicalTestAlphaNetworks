package tv.alphanetworks.training.video_store.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tv.alphanetworks.training.video_store.dtos.MovieDto;
import tv.alphanetworks.training.video_store.services.MovieService;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/getMovies")
    public ResponseEntity<List<MovieDto>> list() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/dvds")
    public ResponseEntity<List<MovieDto>> getAllDVDs() {
        List<MovieDto> dvds = movieService.getAllDVDs();
        return ResponseEntity.ok(dvds);
    }

    @GetMapping("/vhs")
    public ResponseEntity<List<MovieDto>> getAllVHS() {
        List<MovieDto> vhs = movieService.getAllVHS();
        return ResponseEntity.ok(vhs);
    }

    @GetMapping("/duplicates")
    public ResponseEntity<List<MovieDto>> getDuplicateMovies() {
        List<MovieDto> duplicates = movieService.getDuplicateMovies();
        return ResponseEntity.ok(duplicates);
    }

    @GetMapping("/available-duplicates")
    public ResponseEntity<List<MovieDto>> getAvailableDuplicateMovies() {
        List<MovieDto> availableDuplicates = movieService.getAvailableDuplicateMovies();
        return ResponseEntity.ok(availableDuplicates);
    }

    @GetMapping(value = "/getMoviesById/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(this.movieService.getById(id));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<MovieDto> register(@RequestBody MovieDto movie) {
        return ResponseEntity.ok(this.movieService.register(movie));
    }

    @GetMapping("getMoviesByName/{name}")
    public ResponseEntity<List<MovieDto>> getCustomerByName(@PathVariable String name) {
        List<MovieDto> movies = movieService.getByName(name);
        if (movies != null) {
            return ResponseEntity.ok(movies);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
