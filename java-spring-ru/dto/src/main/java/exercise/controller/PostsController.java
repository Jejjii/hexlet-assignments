package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll(); // Получение списка постов из репозитория
        return posts.stream().map(this::convertToPostDTO).collect(Collectors.toList());
    }

    private PostDTO convertToPostDTO(Post post) {
        List<Comment> comments = commentRepository.findByPostId(post.getId());
        List<CommentDTO> commentDTOs = comments.stream()
                .map(comment -> new CommentDTO(comment.getId(), comment.getBody()))
                .collect(Collectors.toList());
        return new PostDTO(post.getId(), post.getTitle(), post.getBody(), commentDTOs);
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable long id) {

        var post =  postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        return convertToPostDTO(post);
    }




}
// END
