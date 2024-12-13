package com.example.gestiontask.Controller;

import com.example.gestiontask.Model.Task;
import com.example.gestiontask.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    //List Task
    @GetMapping
    public List<Task> ListTask(){
        return taskService.ListTask();
    }

    //List Id
    @GetMapping("/{id}")
    public Task obtenerTarea(@PathVariable Long id) {
        return taskService.obtenerTask(id);
    }

    //New Task
    @PostMapping
    public Task NewTask(@RequestBody Task task) {
        return taskService.NewTask(task);
    }

    //Update Task
    @PutMapping("/{id}")
    public Task actualizarTask(@PathVariable Long id, @RequestBody Task task){
        return taskService.actualizarTarea(id, task);
    }

    //Delete Task
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTarea(@PathVariable Long id) {
        try {
            taskService.eliminarTarea(id);
            return ResponseEntity.ok("Tarea eliminada exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
