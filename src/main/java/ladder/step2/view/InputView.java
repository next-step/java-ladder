package ladder.step2.view;

import ladder.step2.domain.Participants;

import java.util.Scanner;

public class InputView {

  private static final InputView instance = new InputView();
  private static final Scanner scanner = new Scanner(System.in);

  private InputView () { }

  public Participants inputNames () {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return Participants.ofString(scanner.nextLine());
  }

  public int inputHeight () {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return Integer.parseInt(scanner.nextLine());
  }

  public static InputView getInstance() {
    return instance;
  }


}
