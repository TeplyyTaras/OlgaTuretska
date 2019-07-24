package teplyy.taras.olgaglass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teplyy.taras.olgaglass.dto.request.ReviewRequest;
import teplyy.taras.olgaglass.dto.response.ReviewResponse;
import teplyy.taras.olgaglass.entity.Review;
import teplyy.taras.olgaglass.entity.User;
import teplyy.taras.olgaglass.reposotory.ReviewRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import static teplyy.taras.olgaglass.tool.Constants.KIEV_ZONE;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductService productService;

    public void save(ReviewRequest reviewRequest) {
        reviewRepository.save(reviewRequestToReview(null, reviewRequest));
    }

    public List<ReviewResponse> findAll() {
        return reviewRepository.findAll().stream().map(ReviewResponse::new).collect(Collectors.toList());
    }

    public List<ReviewResponse> findAllByProductId(Long productId) {
        return reviewRepository.findAllByProductId(productId).stream().map(ReviewResponse::new).collect(Collectors.toList());
    }

    public List<ReviewResponse> findAllToShowByProductId(Long productId) {
        return reviewRepository.findAllByProductIdAndHiddenIsFalse(productId).stream().map(ReviewResponse::new).collect(Collectors.toList());
    }

    public void update(Long id, ReviewRequest request) {
        reviewRepository.save(reviewRequestToReview(findOne(id), request));
    }

    public void delete(Long id) {
        reviewRepository.delete(findOne(id));
    }




    public Review findOne(Long id) {
        return reviewRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Review with id " + id + " not exists"));
    }

    private Review reviewRequestToReview(Review review , ReviewRequest reviewRequest) {
        if (review == null) {
            review = new Review();
            review.setHidden(true);
            review.setDatePosted(LocalDateTime.now(ZoneId.of(KIEV_ZONE)));
        }
        review.setUserName(reviewRequest.getUserName());
        review.setText(reviewRequest.getText());
        review.setProduct(productService.findOne(reviewRequest.getProductId()));
        return review;
    }
}
