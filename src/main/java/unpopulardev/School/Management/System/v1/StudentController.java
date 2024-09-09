package unpopulardev.School.Management.System.v1;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("")
    List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    Student findBy(@PathVariable Integer id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()){
            throw new RunNotFoundException();
        }
        return student.get();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Student student){
        studentRepository.create(student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Student student, @PathVariable Integer id){
        studentRepository.update(student,id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        studentRepository.delete(id);  // Use deleteById for deleting by id
    }
}
