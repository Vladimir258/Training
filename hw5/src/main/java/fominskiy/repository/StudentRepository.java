package fominskiy.repository;

import fominskiy.model.Student;
import java.util.List;

public interface StudentRepository extends Repository<Student,Long> {
    Long countAll();
    List<Student> findByName(String name);
    void removeAll();
}
