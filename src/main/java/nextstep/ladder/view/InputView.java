package nextstep.ladder.view;

import nextstep.ladder.domain.entity.LadderHeight;
import nextstep.ladder.domain.entity.Names;
import nextstep.ladder.domain.entity.PrizeGroup;

import java.util.Scanner;

public class InputView {

  private static final String INPUT_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
  private static final String INPUT_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
  private static final String INPUT_TARGET = "결과를 보고 싶은 사람은? (all을 입력 하면 전체 결과를 출력하고 종료합니다.)";
  private static final String ERROR_TARGET_MESSAGE = "잘못된 결과 입력입니다.";
  
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

  public PrizeGroup inputWinner(Names names) {
    System.out.println(INPUT_RESULTS);

    return new PrizeGroup(scanner.next(), names);
  }

  public String inputTarget() {
    System.out.println(INPUT_TARGET);
    String value = scanner.next();

    validString(value);

    return value;
  }

  private void validString(String value) {
    if (value == null || value.isEmpty()) {
      throw new IllegalArgumentException(ERROR_TARGET_MESSAGE);
    }
  }

}
