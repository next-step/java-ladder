package laddergame.view;

import laddergame.model.Ladder;
import laddergame.model.LadderResultMapper;
import laddergame.model.PlayerName;
import laddergame.model.PlayerNames;
import laddergame.model.PlayerNotExistException;
import laddergame.model.ResultNames;

public class LadderGameView {

  private final static String COLON_WITH_WHITESPACE = " : ";
  private final static String NEWLINE = System.lineSeparator();

  public static void printInputPlayerNamesMsg() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
  }

  public static void printInputResultNamesMsg() {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
  }

  public static void printInputLadderHeightMsg() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
  }

  public static void printLadder(PlayerNames players, Ladder ladder, ResultNames results) {
    StringBuilder sb = new StringBuilder("실행결과").append(NEWLINE);

    sb.append(players.toString()).append(NEWLINE);

    ladder.getLineDTOs().forEach(lineDTO -> {
      sb.append(lineDTO.getLineWithMappedPoint())
          .append(NEWLINE);
    });

    sb.append(results.toString());

    System.out.println(sb);
  }

  public static void printInputPlayerForResultMsg() {
    System.out.println("결과를 보고 싶은 사람은?");
  }

  public static void printResultOf(LadderResultMapper ladderResultMapper, PlayerName playerName) {
    StringBuilder sb = new StringBuilder("실행 결과").append(NEWLINE);

    try {
      sb.append(playerName.toString()).append(COLON_WITH_WHITESPACE)
          .append(ladderResultMapper.getResultOf(playerName));
    } catch (PlayerNotExistException e) {
      sb.append(e.getMessage());
    }

    System.out.println(sb);
  }

  public static void printResultOfAll(LadderResultMapper ladderResultMapper) {
    StringBuilder sb = new StringBuilder("실행 결과").append(NEWLINE);

    ladderResultMapper.getResults().forEach(resultEntry -> {
      sb.append(resultEntry.getKey())
          .append(COLON_WITH_WHITESPACE)
          .append(resultEntry.getValue())
          .append(NEWLINE);
    });

    System.out.println(sb);
  }
}
