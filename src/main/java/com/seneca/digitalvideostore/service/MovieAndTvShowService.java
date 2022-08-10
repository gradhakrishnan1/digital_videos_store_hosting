package com.seneca.digitalvideostore.service;

import com.seneca.digitalvideostore.model.MovieAndTvShowData;
import com.seneca.digitalvideostore.model.ShowType;
import com.seneca.digitalvideostore.repository.MovieAndTvDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class MovieAndTvShowService {

    private final MovieAndTvDataRepository repository;

    public MovieAndTvShowService(MovieAndTvDataRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public MovieAndTvShowData addMovieAndTvShowData(MovieAndTvShowData showData) {
        return repository.save(showData);
    }

    public List<MovieAndTvShowData> getAllMovies() {
        return repository.findByShowType(ShowType.MOVIE);
    }

    public List<MovieAndTvShowData> getAllTvShows() {
        return repository.findByShowType(ShowType.TV);
    }

    public List<MovieAndTvShowData> getAllShowDataWithTitle(String title) {
        return repository.findByNameContainsIgnoreCase(title);
    }

    public List<MovieAndTvShowData> getAllFeaturedShowData(ShowType showType) {
        return repository.findFeaturedShowsByType(showType);
    }

    public MovieAndTvShowData getShowByName(String showName) {
        Optional<MovieAndTvShowData> showDataOptional = repository.findByName(showName);
        if (showDataOptional.isEmpty()) {
            throw new RuntimeException("No show data found for name: " + showName);
        }

        return showDataOptional.get();
    }

    public MovieAndTvShowData updateMovieAndTvShowRentPrice(String showName, BigDecimal rentPrice) {
        Optional<MovieAndTvShowData> showDataOptional = repository.findByName(showName);
        if (showDataOptional.isEmpty()) {
            throw new RuntimeException("No show data found for name: " + showName);
        }

        showDataOptional.get().setRentPrice(rentPrice);
        return repository.save(showDataOptional.get());
    }

    public void deleteMovieAndTvShowData(String showName) {
        repository.deleteByName(showName);
    }
}
