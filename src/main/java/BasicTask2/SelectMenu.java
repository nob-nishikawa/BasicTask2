package BasicTask2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SelectMenu {

  public int selectMenu(Scanner scanner) {

    int menuNumber = 0;
    while (true) {
      try {
        System.out.println("学生を追加：１");
        System.out.println("学生を削除：２");
        System.out.println("点数を更新：３");
        System.out.println("平均点の計算：４");
        System.out.println("全学生の情報を表示：５");
        System.out.println("終了：６");

        System.out.println("数字を選択してください[1-6]");

        menuNumber = scanner.nextInt();
        break;
      } catch (InputMismatchException e) {
        System.err.println("入力されたものは数字ではありません");
      }
    }
    return (menuNumber);
  }

}
