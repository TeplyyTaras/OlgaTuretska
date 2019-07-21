package teplyy.taras.olgaglass.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teplyy.taras.olgaglass.dto.request.ReviewRequest;
import teplyy.taras.olgaglass.dto.response.ReviewResponse;
import teplyy.taras.olgaglass.service.ReviewService;

import javax.validation.Valid;

import java.util.List;

import static teplyy.taras.olgaglass.tool.Constants.REVIEW_URL;

@CrossOrigin
@RestController
@RequestMapping(REVIEW_URL)
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public void create(@Valid @RequestBody ReviewRequest reviewRequest) {
        reviewService.save(reviewRequest);
    }

    @GetMapping()
    public List<ReviewResponse> findAll() {
        return reviewService.findAll();
    }

//    @GetMapping("/byProduct")
//    public List<ReviewResponse> findAllByProductId(Long productId) {
//        return reviewService.findAllByProductId(productId);
//    }
//
//    @GetMapping("/showByProduct")
//    public List<ReviewResponse> findAllToShowByProductId(Long productId) {
//        return reviewService.findAllToShowByProductId(productId);
//    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody ReviewRequest reviewRequest) {
        reviewService.update(id, reviewRequest);
    }

    @DeleteMapping
    public void delete(Long id) {
        reviewService.delete(id);
    }
}
