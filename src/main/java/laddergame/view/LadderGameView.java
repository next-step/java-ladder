package laddergame.view;

import laddergame.model.Ladder;

public class LadderGameView {

  public static void printInputNameMsg() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
  }

  public static void printInputLadderHeightMsg() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
  }

  public static void printResult(Ladder ladder) {
    StringBuilder sb = new StringBuilder("실행결과\n");

    sb.append(ladder.getPlayers().toString()).append("\n");

    ladder.getLines().stream()
        .forEach(line -> sb.append(line).append("\n"));

    System.out.println(sb);
  }
}
