package br.com.miguellucas.todolist.task;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;
    @PostMapping("/")
    public ResponseEntity createTask(@RequestBody TaskModel taskModel, HttpServletRequest request){

        System.out.println("Chegou no controller: ");
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);

        if (taskModel.getTitle().length() > 50){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error 500. Titulo muito grande");
        }
        var task = this.taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);

    }


}
