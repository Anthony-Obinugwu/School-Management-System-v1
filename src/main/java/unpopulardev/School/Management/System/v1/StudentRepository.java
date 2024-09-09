package unpopulardev.School.Management.System.v1;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    List<Student> findAll(){
        return students;
    }

    Optional<Student> findById(Integer id){
        return students.stream()
                .filter(student -> student.id().equals(id))
                .findFirst();
    }

    void create(Student student){
        students.add(student);
    }

    void update(Student student, Integer id){
        findById(id).ifPresentOrElse(
                existingStudent -> students.set(students.indexOf(existingStudent), student), () -> {
                    throw new IllegalArgumentException("Student not found");
                }
        );
    }

    void delete(Integer id) {
        students.removeIf(student -> student.id().equals(id));
    }

    @PostConstruct
    private void init() {
        students.add(new Student(
                1,
                "Anthony",
                "Chinedu",
                LocalDate.of(2009,10,12),
                "SS1"
        ));
        System.out.println("Age of student: " + AgeCalculator.calculateAge(students.get(0).birthDate()));
    }
}
