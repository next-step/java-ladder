package nextstep.ladder.view;

import java.util.Arrays;
import java.util.Scanner;
import nextstep.ladder.Participants;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  public static Participants readParticipants() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    String[] raw = scanner.nextLine().split(",");
    return Participants.of(Arrays.asList(raw));
  }

  public static int readLadderHeight() {
    System.out.println("\n최대 사다리 높이는 몇 개인가요?");
    return scanner.nextInt();
  }

  public static void closeScanner() {
    scanner.close();
  }
}
