package ladder.view.input;

import ladder.domain.Height;

public class InputHeightView extends InputView{

  public static Height scanLadderHeight() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    String height = SCANNER.nextLine();
    validateIsNumber(height);
    return new Height(parseInt(height));
  }

  private static void validateIsNumber(String height) {
    if(isNotNumber(height)){
      throw new IllegalArgumentException("숫자만 입력 가능합니다.");
    }
  }

  private static boolean isNotNumber(String height) {
    return !height.matches("^[0-9]*$");
  }

  private static int parseInt(String height) {
    return Integer.parseInt(height);
  }

}
