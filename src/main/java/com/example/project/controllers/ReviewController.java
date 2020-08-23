package com.example.project.controllers;

import com.example.project.models.Product;
import com.example.project.models.Review;
import com.example.project.services.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/api/products/{pid}/reviews")
    public Review createReview(
            @PathVariable("pid") String pid,
            @RequestBody Review newReview) {
        return reviewService.createReview(pid, newReview);
    }


    @GetMapping("/api/products/{pid}/reviews")
    public List<Review> findAllReviewsByProductId(
            @PathVariable("pid") String pid)
    {
        return reviewService.findAllReviewsByProductId(pid);
    }

    @PutMapping("/api/reviews/{rid}")
    public Review updateReview(
            @PathVariable("rid") Integer ReviewId,
            @RequestBody Review newReview) {
        return reviewService.updateReview(ReviewId, newReview);
    }

    @DeleteMapping("/api/reviews/{rid}")
    public List<Review> deleteReview(
            @PathVariable("rid") Integer rid) {
        return reviewService.deleteReview(rid);
    }

}
