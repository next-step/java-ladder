package ladder.step2.view;

import ladder.step2.domain.Participants;

import java.util.Scanner;

public class InputView {

  private static final InputView INSTANCE = new InputView();
  private static final Scanner SCANNER = new Scanner(System.in);
  private static final String NEW_LINE = System.lineSeparator();

  private InputView () { }

  public Participants inputParticipants() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return Participants.ofString(SCANNER.nextLine());
  }

  public int inputHeight () {
    System.out.println(NEW_LINE + "최대 사다리 높이는 몇 개인가요?");
    return Integer.parseInt(SCANNER.nextLine());
  }

  public static InputView getInstance() {
    return INSTANCE;
  }


}
