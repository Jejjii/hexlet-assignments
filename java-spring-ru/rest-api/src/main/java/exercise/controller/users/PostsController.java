package exercise.controller.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

import static exercise.Data.getPosts;

// BEGIN
@RequestMapping("/api")
@RestController
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable int userId) {
        List<Post> userPosts = posts.stream()
                .filter(post -> post.getUserId() == userId)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userPosts);
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Post> createPost(@PathVariable int userId, @RequestBody Post post) {
        post.setUserId(userId);
        posts.add(post); // предполагается, что posts - это ваш список постов
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
}
// END
