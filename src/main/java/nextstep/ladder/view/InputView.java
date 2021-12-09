package nextstep.ladder.view;

import nextstep.ladder.domain.entity.LadderHeight;
import nextstep.ladder.domain.entity.Names;

import java.util.Scanner;

public class InputView {

  private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
  
  private static final InputView instance = new InputView();
  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {}

  public static InputView getInstance() {
    return InputView.instance;
  }

  public Names inputNames() {
    System.out.println(INPUT_NAMES_MESSAGE);
    return new Names(scanner.next());
  }

  public LadderHeight inputLadderHeight() {
    System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
    return new LadderHeight(Integer.parseInt(scanner.next()));
  }
}
