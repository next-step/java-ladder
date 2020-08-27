package nextstep.ladder.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewInput {

  public static final String SCRIPT_PLAYER_NAMES = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  public static final String SCRIPT_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
  public static final String SCRIPT_WINNING_CONTENTS = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
  public static final String SCRIPT_PLAYER_WINNING = "\n결과를 보고 싶은 사람은?";

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
    return Arrays.stream(askPlayerNames().split(","))
        .collect(Collectors.toList());
  }

  private String askPlayerNames() {
    System.out.println(SCRIPT_PLAYER_NAMES);
    return scanner.next();
  }

  public int requestLadderHeight() {
    int ladderHeight = askLadderHeight();
    while (ladderHeight < 1) {
      ladderHeight = askLadderHeight();
    }

    return ladderHeight;
  }

  private int askLadderHeight() {
    System.out.println(SCRIPT_LADDER_HEIGHT);
    return scanner.nextInt();
  }

  public List<String> requestWinningContents() {
    List<String> names = contentsToList();
    while (names.size() < 2) {
      names = namesToList();
    }

    return names;
  }

  private List<String> contentsToList() {
    return Arrays.stream(askWinningContents().split(","))
        .collect(Collectors.toList());
  }

  private String askWinningContents() {
    System.out.println(SCRIPT_WINNING_CONTENTS);
    return scanner.next();
  }

  public String requestPlayerWinning() {
    System.out.println(SCRIPT_PLAYER_WINNING);
    return scanner.next();
  }

}
