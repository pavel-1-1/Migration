package org.example.model;

public class Post {
    private long id;
    private String content;
    private boolean remove = true;

    public Post() {
    }

    public Post(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

    public boolean checkRemove() {
        return remove;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
