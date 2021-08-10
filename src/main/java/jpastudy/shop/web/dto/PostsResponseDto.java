package jpastudy.shop.web.dto;

import jpastudy.shop.domain.posts.Posts;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    //모든 필드를 가진 생성자기 불필요함으로 Entity를 받아서 처리함
    public PostsResponseDto(Posts entity) {
        this.id =entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }




}
