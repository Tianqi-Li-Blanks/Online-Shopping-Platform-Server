package com.example.project.repositories;

import com.example.project.models.Review;

import com.example.project.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository
        extends CrudRepository<Review, Integer>
{
    @Query("SELECT review FROM Review review WHERE review.pid=:pid")
    public List<Review> findAllReviewsByProductId(@Param("pid") String pid);

    @Query("SELECT review FROM Review review WHERE review.id=:rid")
    public Review findReviewById(@Param("rid") Integer rid);
}