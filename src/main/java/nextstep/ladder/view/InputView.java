package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  public static List<String> getParticipantNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    String input = scanner.nextLine();
    return Arrays.stream(input.split(","))
        .collect(Collectors.toList());

  }

  public static int getLadderHeight() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return scanner.nextInt();
  }
}
