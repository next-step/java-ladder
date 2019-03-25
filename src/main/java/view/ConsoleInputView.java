package view;

import java.util.Scanner;

public class ConsoleInputView {


  private Scanner scanner;

  public ConsoleInputView() {
    this.scanner = new Scanner(System.in);
  }

  public String inputParticipantNames() {

    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return this.scanner.next();
  }

  public int inputMaximumLadderHeight() {

    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return this.scanner.nextInt();
  }

}
