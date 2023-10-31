package exercise;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts") // Список постов
    public List<Post> index(@RequestParam(defaultValue = "1") Integer post,
                            @RequestParam(defaultValue = "10") Integer limit) {
        int fromIndex = (post - 1) * limit;
        int toIndex = Math.min(fromIndex + limit,posts.size());
        if(fromIndex > toIndex) {
            return Collections.emptyList();
        }
        return posts.subList(fromIndex,toIndex);
    }

    @PostMapping("/posts") // Создание  нового поста
    public Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }

    @GetMapping("/posts/{id}") // Вывод поста
    public Optional<Post> show(@PathVariable String id) {
        var post = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        return post;
    }

    @PutMapping("/posts/{id}")
    public Post update(@PathVariable String id,@RequestBody Post data) {
        var maybePost = posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if(maybePost.isPresent()) {
            var post = maybePost.get();
            post.setId(data.getId());
            post.setBody(data.getBody());
            post.setTitle(data.getTitle());
        }

        return data;
    }

    @DeleteMapping("/posts/{id}") // Удаление поста
    public void delete(@PathVariable String id) {
        posts.removeIf(p ->p.getId().equals(id));
    }
    // END
}
