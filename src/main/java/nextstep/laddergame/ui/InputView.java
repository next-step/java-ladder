package nextstep.laddergame.ui;

import java.util.Scanner;
import nextstep.laddergame.domain.LadderInfo;
import nextstep.laddergame.domain.Members;
import nextstep.laddergame.factory.MembersFactory;
import nextstep.laddergame.util.StringUtils;

public class InputView {

  private InputView() {
  }

  private static final String MEMBER_DELIMITER = ",";
  private static final Scanner SCANNER = new Scanner(System.in);

  public static String[] inputMembers() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return getInput().split(MEMBER_DELIMITER);
  }

  public static int inputLadderHeight() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return Integer.parseInt(getInput().trim());
  }

  private static String getInput() {
    String input = SCANNER.nextLine();
    StringUtils.checkNullOrBlank(input);
    return input;
  }

}
