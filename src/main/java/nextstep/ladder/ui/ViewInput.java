package nextstep.ladder.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewInput {

  public static final String SCRIPT_PLAYER_NAMES = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  public static final String SCRIPT_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";

  private Scanner scanner;

  public ViewInput(Scanner scanner) {
    this.scanner = scanner;
  }

  public List<String> requestPlayerNames() {
    List<String> names = namesToList();
    while (names.size() < 2) {
      names = namesToList();
    }

    return names;
  }

  private List<String> namesToList() {
    return Arrays.stream(playerNames().split(","))
        .collect(Collectors.toList());
  }

  public int requestLadderHeight() {
    int ladderHeight = ladderHeight();
    while (ladderHeight < 1) {
      ladderHeight = ladderHeight();
    }

    return ladderHeight;
  }

  private String playerNames() {
    System.out.println(SCRIPT_PLAYER_NAMES);
    return scanner.next();
  }

  private int ladderHeight() {
    System.out.println(SCRIPT_LADDER_HEIGHT);
    return scanner.nextInt();
  }

}
