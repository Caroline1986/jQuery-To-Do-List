package models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "todo_item")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    private boolean done;

    public TodoItem() {
    }

    public TodoItem(Long id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public TodoItem(String title, boolean done) {
        this.title = title;
        this.done = done;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

