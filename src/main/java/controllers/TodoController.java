package controllers;


import models.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.TodoRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    @PostMapping
    public String save(@Valid @NotNull @RequestParam(name = "Todo") String todo,
                       @ModelAttribute TodoItem todoItem) { //@Valid is for @NotBlank in model
        todoItem.setTitle(todo);
        todoRepository.save(todoItem);
        return "redirect:/ToDoHome";
    }

    @PutMapping
    public TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }
}
