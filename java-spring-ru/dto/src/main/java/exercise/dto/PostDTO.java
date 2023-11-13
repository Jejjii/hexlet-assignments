package exercise.dto;

import java.util.List;

import exercise.model.Comment;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class PostDTO {
    private List<CommentDTO> comments;

    private long id;

    private String title;

    private String body;

    public PostDTO() {};

    public PostDTO(long id,String title, String body,List<CommentDTO> comments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.comments = comments;
    }


}
// END
