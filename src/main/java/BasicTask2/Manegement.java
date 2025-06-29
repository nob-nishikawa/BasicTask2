package BasicTask2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Manegement {


  public void addStudent(Scanner scanner, List<Student> studentList) {
    String studentName;
    int score;
    while (true) {
      try {
        System.out.println("生徒の名前を入力してください");
        studentName = scanner.next();
        break;

      } catch (InputMismatchException e) {
        System.err.println("入力されたのは文字列ではありません");
        e.printStackTrace();
        scanner.next();
      }
    }
    while (true) {
      try {
        System.out.println("生徒の点数を入力してください");
        score = scanner.nextInt();
        break;
      } catch (InputMismatchException exception) {
        System.err.println("入力は数字ではありません");
        exception.printStackTrace();
        scanner.next();
      }
    }
    Optional<Student> student = Optional.empty();

    for (Student s : studentList) {
      if (Objects.equals(s.getStudentName(), studentName)) {
        student = Optional.of(s);
        break;
      }
    }

    if (student.isPresent()) {
      System.err.println("入力された学生は存在します");
    } else {
      studentList.add(new Student(studentName, score));
    }
    for (Student ss : studentList) {
      System.out.println(ss.getStudentName() + ss.getScore());
    }
  }

  public void removeStudent(Scanner scanner, List<Student> studentList) {
    String studentName = "";
    while (true) {
      try {
        System.out.println("学生の名前を入力してください");
        studentName = scanner.next();
        break;
      } catch (InputMismatchException e) {
        System.err.println("入力されたのは文字ではありません");
        e.printStackTrace();
        scanner.next();
      }

    }
    String finalStudentName = studentName;
    studentList.removeIf(s -> s.getStudentName().equals(finalStudentName));
    Optional<Student> student = Optional.empty();

    for (Student s : studentList) {
      System.out.println(s.getStudentName() + s.getScore());
    }

  }

  public void updateScore(Scanner scanner, List<Student> studentList) {
    String studentName;
    int score;
    while (true) {
      try {
        System.out.println("学生の名前を入力してください");
        studentName = scanner.next();
        break;

      } catch (InputMismatchException e) {
        System.err.println("入力は文字ではありません");
        e.printStackTrace();
        scanner.next();
      }
    }
    while (true) {
      try {
        System.out.println("成績を入力してください");
        score = scanner.nextInt();
        break;
      } catch (InputMismatchException e) {
        System.err.println("入力が数値ではありません");
        e.printStackTrace();
        scanner.next();
      }
    }

//    Optional<Student> student = studentList.stream()
//        .filter(s -> Objects.equals(s.getStudentName(), studentName));
    Optional<Student> student = Optional.empty();
    for (Student s : studentList) {
      if (Objects.equals(s.getStudentName(), studentName)) {
        student = Optional.of(s);
        break;
      }
    }
    if (student.isPresent()) {
      student.get().setScore(score);
    } else {
      System.err.println(studentName + "さんは見つかりませんでした");
    }
    for (Student ss : studentList) {
      System.out.println(ss.getStudentName() + ss.getScore());
    }

  }

  public void calcAverage(List<Student> studentList) {
    double scoreAverage = studentList.stream()
        .mapToInt(Student::getScore)
        .average()
        .orElse(0.0);
    System.out.println(scoreAverage);

  }

  public void seachAll(List<Student> studentList) {

    studentList.stream()
        .forEach(s -> System.out.println(s.getStudentName() + ":" + s.getScore()));

  }
}
