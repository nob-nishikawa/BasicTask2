package BasicTask2;

public class Student {

  String studentName;
  int score;

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }


  public Student(String studentName, int score) {
    this.studentName = studentName;
    this.score = score;
  }
}
