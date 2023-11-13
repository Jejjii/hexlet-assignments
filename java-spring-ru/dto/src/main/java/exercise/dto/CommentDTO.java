package exercise.dto;

import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
public class CommentDTO {
    private long id;
    private String body;

    public CommentDTO() {};

    public CommentDTO(long id, String body) {
        this.id = id;
        this.body = body;
    }

}
// END
