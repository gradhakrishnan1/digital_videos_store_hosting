package com.seneca.digitalvideostore.repository;

import com.seneca.digitalvideostore.model.MovieAndTvShowData;
import com.seneca.digitalvideostore.model.ShowType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieAndTvDataRepository extends MongoRepository<MovieAndTvShowData, String> {
    Optional<MovieAndTvShowData> findByName(String showName);
    List<MovieAndTvShowData> findByShowType(ShowType showType);
    List<MovieAndTvShowData> findByNameContainsIgnoreCase(String title);

    @Query(value = "{'isFeatured':true, 'showType':?0}")
    List<MovieAndTvShowData> findFeaturedShowsByType(ShowType showType);

    void deleteByName(String showName);
}
