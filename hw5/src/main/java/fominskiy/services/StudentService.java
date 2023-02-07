package fominskiy.services;

import fominskiy.model.Student;
import fominskiy.repository.StudentRepository;
import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void printTotalCount() {
        System.out.println("Количество записей в БД: " + studentRepository.countAll());
    }

    public Student findStudentById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    public void printAllStudents(){
        System.out.println("Полный список студентов:");
        studentRepository.findAll().forEach(System.out::println);
    }

    public void addStudents(int amount) {
        System.out.println("Добавление новых записей: " + amount);
        for (int i = 1; i <= amount; i++) {
            studentRepository.save(new Student("Student_" + i));
        }
    }

    public void removeAllStudents() {
        System.out.println("Очистка таблицы (удаление всех записей)");
        studentRepository.removeAll();
    }

    public void deleteStudentById(Long id){
        studentRepository.deleteById(id);
    }

    public Student renameStudent(Long id, String newName){

        if (studentRepository.countAll() == 0) return null;
        Student student = studentRepository.findById(id);
        if (student != null) {
            student.setName(newName);
            studentRepository.update(student);
            return student;
        }
        return null;
    }

}
