package nextstep.ladder.presentation;

import java.util.Scanner;
import nextstep.ladder.domain.PlayerNames;

public class InputView {

  private final Scanner scanner = new Scanner(System.in);
  public PlayerNames getPlayerNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

    // split을 여기서 할까 PlayerNames에서 할까 고민하다가, 자르는 건 view의 책임이라 판단해 여기서 함
    return new PlayerNames(scanner.nextLine().split(","));
  }

  public int getLadderLength() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");

    return scanner.nextInt();
  }
}
