package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Participants;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  public static List<String> getParticipantNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return getStringList();
  }

  public static List<String> getExecutionResult() {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    return getStringList();
  }


  public static int getLadderHeight() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return scanner.nextInt();
  }

  public static String getQueryName() {
    System.out.println("결과를 보고 싶은 사람은?");
    return scanner.nextLine();
  }

  private static List<String> getStringList() {
    String input = scanner.nextLine();
    return Arrays.stream(input.split(","))
        .collect(Collectors.toList());
  }
}
