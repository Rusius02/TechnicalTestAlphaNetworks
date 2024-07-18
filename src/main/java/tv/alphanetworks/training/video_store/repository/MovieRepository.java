package tv.alphanetworks.training.video_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tv.alphanetworks.training.video_store.model.Customer;
import tv.alphanetworks.training.video_store.model.Movie;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE m.title = :title")
    List<Movie> findByTitle(@Param("title") String title);
    boolean existsByTitle(String title);
    @Query("SELECT m FROM Movie m WHERE TYPE(m) = DVD")
    List<Movie> findAllByTypeDVD();

    @Query("SELECT m FROM Movie m WHERE TYPE(m) = VHS")
    List<Movie> findAllByTypeVHS();
    @Query("SELECT m.title, m.releaseDate, COUNT(m) FROM Movie m GROUP BY m.title, m.releaseDate HAVING COUNT(m) > 1")
    List<Object[]> findDuplicateMovies();
    List<Movie> findByTitleAndReleaseDate(String title, LocalDateTime releaseDate);
    @Query("SELECT m.title, m.releaseDate, COUNT(m) " +
            "FROM Movie m LEFT JOIN m.rentals r " +
            "WHERE r.returnDate IS NOT NULL OR r IS NULL " +
            "GROUP BY m.title, m.releaseDate " +
            "HAVING COUNT(m) > 1")
    List<Object[]> findAvailableDuplicateMovies();
    @Query("SELECT m FROM Movie m " +
            "LEFT JOIN m.rentals r " +
            "WHERE m.title = :title " +
            "AND m.releaseDate = :releaseDate " +
            "AND (r IS NULL OR r.returnDate IS NOT NULL)")
    List<Movie> findAvailableByTitleAndReleaseDate(@Param("title") String title, @Param("releaseDate") LocalDateTime releaseDate);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN false ELSE true END " +
            "FROM Rental r JOIN r.movies m " +
            "WHERE m.id = :movieId AND r.returnDate IS NULL")
    boolean isMovieAvailable(@Param("movieId") Long movieId);
}
