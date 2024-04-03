package ladder.view;

import ladder.domain.*;
import ladder.dto.LaddersDto;
import ladder.dto.PlayerDto;
import ladder.dto.PrizeDto;
import ladder.dto.RowDto;

import java.util.List;

public class ResultView {
  private static final String OFFSET = "     ";
  private static final String PARALLEL = "-----";
  private static final String VERTICAL = "|";

  public static void displayResult(StatusDto result) {
    StringBuilder sb = new StringBuilder("실행 결과\n");
    sb.append(playersBuilder(result.getPlayers()));
    sb.append(laddersBuilder(result.getLadders()));
    sb.append(prizesBuilder(result.getPrizes()));

    System.out.println(sb);
  }

  private static StringBuilder laddersBuilder(LaddersDto ladders) {
    final StringBuilder sb = new StringBuilder();
    for (RowDto row : ladders.getRows()) {
      sb.append(rowBuilder(row));
    }

    return sb;
  }

  private static StringBuilder playersBuilder(List<PlayerDto> players) {
    StringBuilder sb = new StringBuilder();
    for (PlayerDto player : players) {
      sb.append(String.format("%6s", player.getName()));
    }
    sb.append("\n");

    return sb;
  }

  private static StringBuilder rowBuilder(RowDto row) {
    final StringBuilder sb = new StringBuilder();
    sb.append(OFFSET);

    for (Boolean isExisting : row.getValues()) {
      sb.append(VERTICAL);
      sb.append(parallel(isExisting));
    }

    sb.append(VERTICAL);
    sb.append("\n");

    return sb;
  }

  private static String parallel(Boolean exist) {
    if (exist) {
      return PARALLEL;
    }
    return OFFSET;
  }

  private static StringBuilder prizesBuilder(List<PrizeDto> prizes) {
    StringBuilder sb = new StringBuilder();
    for (PrizeDto prize : prizes) {
      sb.append(String.format("%6s", prize.getValue()));
    }
    sb.append("\n");

    return sb;
  }
}
