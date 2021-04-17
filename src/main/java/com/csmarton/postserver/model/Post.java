package com.csmarton.postserver.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Post
{
    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String postId;

    private String title;

    private String content;

    public Post() {
    }

    public Post(final String postId, final String title, final String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((title == null) ? 0 : title.hashCode());
        result = prime * result
                + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((postId == null) ? 0 : postId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && postId.equals(post.postId) && title.equals(post.title) && content.equals(post.content);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postId='" + postId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
