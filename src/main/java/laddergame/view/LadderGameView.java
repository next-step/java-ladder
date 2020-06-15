package laddergame.view;

import java.util.Map;
import laddergame.model.Ladder;
import laddergame.model.Name;
import laddergame.model.Names;

public class LadderGameView {

  private final static Name ALL = new Name("all");
  private final static String COLON_WITH_WHITESPACE = " : ";
  private final static String NEWLINE = "\n";

  public static void printInputPlayerNamesMsg() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
  }

  public static void printInputResultNamesMsg() {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
  }

  public static void printInputLadderHeightMsg() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
  }

  public static void printLadder(Names players, Ladder ladder, Names results) {
    StringBuilder sb = new StringBuilder("실행결과").append(NEWLINE);

    sb.append(players.toString()).append(NEWLINE);

    ladder.getLines().forEach(line -> sb.append(line).append(NEWLINE));

    sb.append(results.toString());

    System.out.println(sb);
  }

  public static void printInputResultOfPlayerMsg() {
    System.out.println("결과를 보고 싶은 사람은?");
  }

  public static void printResult(Map<Name, Name> resultMap, Name playerName) {
    System.out.println(getResultMessage(resultMap, playerName));
  }

  private static String getResultMessage(Map<Name, Name> resultMap, Name playerName) {
    StringBuilder sb = new StringBuilder("실행 결과").append(NEWLINE);

    if (playerName.equals(ALL)) {
      resultMap.keySet().forEach(key -> {
        sb.append(key).append(COLON_WITH_WHITESPACE).append(resultMap.get(key)).append(NEWLINE);
      });
      return sb.toString();
    }

    try {
      sb.append(playerName.toString()).append(COLON_WITH_WHITESPACE)
          .append(resultMap.get(playerName).toString());
    } catch (NullPointerException e) {
      sb.append("없는 사람입니다.");
    }
    return sb.toString();
  }
}
