package com.example.gestiontask.Service;

import com.example.gestiontask.Model.Task;
import com.example.gestiontask.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    //List Task
    public List<Task> ListTask(){
        return taskRepository.findAll();
    }
    //Get a Task
    public Task obtenerTask(Long id){
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea No Encontrada"));
    }
    //New Task
    public Task NewTask(Task task){
        return taskRepository.save(task);
    }

    public Task actualizarTarea(Long id, Task tareaDetalles) {
        Task tarea = obtenerTask(id);
        tarea.setTitle(tareaDetalles.getTitle());
        tarea.setDescription(tareaDetalles.getDescription());
        tarea.setCompleted(tareaDetalles.isCompleted());
        return taskRepository.save(tarea);
    }

    public void eliminarTarea(Long id) {
        if (!taskRepository.existsById(id)){
            throw new RuntimeException("Tarea no Encontrada");
        }
        taskRepository.deleteById(id);
    }
}
