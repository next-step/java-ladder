package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewInput {

  private Scanner scanner;

  public ViewInput(Scanner scanner) {
    this.scanner = scanner;
  }

  public Players ready() {
    List<String> playerNames = namesToList();
    int ladderHeight = ladderHeight();

    return Players.valueOf(playerNames, ladderHeight);
  }

  private List<String> namesToList() {
    return Arrays.stream(playerNames().split(","))
        .collect(Collectors.toList());
  }

  private String playerNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return scanner.next();
  }

  private int ladderHeight() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return scanner.nextInt();
  }

}
