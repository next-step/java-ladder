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
  private static final Scanner sc = new Scanner(System.in);

  public static Members inputMembers() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    String[] names = getInput().split(MEMBER_DELIMITER);
    return MembersFactory.createMembers(names);
  }

  public static LadderInfo inputLadderHeight(int width) {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    int height = Integer.parseInt(getInput().trim());

    return new LadderInfo(height, width);
  }

  private static String getInput() {
    String input = sc.nextLine();
    StringUtils.checkNullOrBlank(input);
    return input;
  }

}
