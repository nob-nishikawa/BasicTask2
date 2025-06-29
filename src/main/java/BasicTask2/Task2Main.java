package BasicTask2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2Main {

  public static void main(String[] args) {

    int menuNumber;
    SelectMenu selectMenu = new SelectMenu();
    Manegement manegement = new Manegement();
    List<Student> studentList = inputInitialValue();

    try (Scanner scanner = new Scanner(System.in)) {
      menuNumber = selectMenu.selectMenu(scanner);

      switch (menuNumber) {
        case 1 -> manegement.addStudent(scanner, studentList);
        case 2 -> manegement.removeStudent(scanner, studentList);
        case 3 -> manegement.updateScore(scanner, studentList);
        case 4 -> manegement.calcAverage(studentList);
        case 5 -> manegement.seachAll(studentList);
        case 6 -> {
          System.out.println("処理を終了します");

        }
        default -> System.err.println("有効な数字が入力されていません");

      }
    }
  }

  public static List<Student> inputInitialValue() {
//    Path filePath = Paths.get("InitialData.csv");
    String filePath = "InitialData.csv";
    List<Student> studentList = new ArrayList<>();

//    try (Stream<String> lines = Files.lines(filePath)) {
    try (InputStream is = Task2Main.class.getClassLoader().getResourceAsStream(filePath)) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
      {
        studentList = reader.lines()
            .skip(1)
            .map(line -> {
              String[] data = line.split(",");

              if (data.length < 2) {
                System.err.println("不正な行をスキップする" + line);
                return null;
              }
              try {
                return new Student(data[0], Integer.parseInt(data[1]));
              } catch (NumberFormatException e) {
                System.err.println("点数の解析エラー" + line + "-" + e.getMessage());
                return null;
              }
            })
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
      }

    } catch (Exception e) {
      System.err.println("ファイルが開けませんでした");
      e.printStackTrace();
    }
    return studentList;
  }

  public static void OutputStudentData(Student student) {
    Path filePath = Paths.get("StudentData.csv");

    List<Student> studentsList = new ArrayList<>();


  }
}
