package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import nextstep.ladder.Participants;
import nextstep.ladder.Results;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  public static Participants readParticipants() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    String[] raw = scanner.nextLine().split(",");
    return Participants.of(Arrays.asList(raw));
  }

  public static Results readResults() {
    System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    String input = scanner.nextLine();
    List<String> results = Arrays.asList(input.split(","));
    return new Results(results);
  }

  public static int readLadderHeight() {
    System.out.println("\n최대 사다리 높이는 몇 개인가요?");
    int height = scanner.nextInt();
    scanner.nextLine();
    return height;
  }

  public static String readQuery() {
    System.out.println("\n결과를 보고 싶은 사람은?");
    return scanner.nextLine();
  }

  public static void closeScanner() {
    scanner.close();
  }
}
