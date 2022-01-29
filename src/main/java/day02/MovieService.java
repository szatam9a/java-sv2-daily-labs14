package day02;

import java.util.List;

public class MovieService {
    private List<Movie> movies;

    public MovieService(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public int longestMoviesLength() {
        return movies.stream().mapToInt(e -> e.getLength()).max().orElseThrow(() -> new IllegalArgumentException("no movie"));
    }

    public List<Movie> moviesWithActor(String actor) {
        return movies.stream().filter(e -> e.getActors().contains(actor)).toList();
    }
}
