package com.seneca.digitalvideostore.controller;

import com.seneca.digitalvideostore.model.MovieAndTvShowData;
import com.seneca.digitalvideostore.model.ShowType;
import com.seneca.digitalvideostore.service.MovieAndTvShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("movieAndTvShow")
public class MovieAndTvShowController {

    private final MovieAndTvShowService service;

    public MovieAndTvShowController(MovieAndTvShowService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MovieAndTvShowData> addMovieAndTvShowData(@RequestBody @Valid MovieAndTvShowData showData) {
        return ResponseEntity.ok(service.addMovieAndTvShowData(showData));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieAndTvShowData>> getAllMovies() {
        return ResponseEntity.ok(service.getAllMovies());
    }

    @GetMapping("/tv")
    public ResponseEntity<List<MovieAndTvShowData>> getAllTvShows() {
        return ResponseEntity.ok(service.getAllTvShows());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<MovieAndTvShowData>> getAllShowDataWithTitle(@PathVariable String title) {
        return ResponseEntity.ok(service.getAllShowDataWithTitle(title));
    }

    @GetMapping("/featured")
    public ResponseEntity<List<MovieAndTvShowData>> getAllFeaturedShowData(@RequestParam ShowType showType) {
        return ResponseEntity.ok(service.getAllFeaturedShowData(showType));
    }

    @GetMapping("/{showName}")
    public ResponseEntity<MovieAndTvShowData> getShowByName(@PathVariable String showName) {
        return ResponseEntity.ok(service.getShowByName(showName));
    }

    @PutMapping
    public ResponseEntity<MovieAndTvShowData> updateMovieAndTvShowRentPrice(@RequestParam String showName,
                                                                            @RequestParam BigDecimal rentPrice) {
        return ResponseEntity.ok(service.updateMovieAndTvShowRentPrice(showName, rentPrice));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMovieAndTvShowData(@RequestParam String showName) {
        service.deleteMovieAndTvShowData(showName);
        return ResponseEntity.accepted().build();
    }
}
