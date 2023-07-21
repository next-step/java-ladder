package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.dto.Rewards;

public class Referee {

  private final static int POINT_START_INDEX = 0;

  public static Rewards getResults(Ladder ladder, PlayerNames playerNames, Rewards rewards) {

    int ladderLength = ladder.getLadderLength();
    int playerCount = playerNames.size();

    List<Integer> resultIndexes = getResultIndexes(playerCount);
    for (int row = POINT_START_INDEX; row < ladderLength; row++) {
      for (int column = POINT_START_INDEX; column < playerCount - 1; column++) {
        LadderPoint ladderPoint = new LadderPoint(row, ladderLength, column, playerCount);
        LadderBarStatus ladderBarStatus = ladder.getLadderBarStatus(ladderPoint);

        if (ladderBarStatus.isEmpty()) {
          continue;
        }

        Collections.swap(resultIndexes, column, column + 1);
      }

    }

    String[] processedResults = new String[playerCount];
    for (int i = 0; i < playerCount; i++) {
      processedResults[resultIndexes.get(i)] = rewards.getRewards(i);
    }

    return new Rewards(processedResults);
  }

  private static List<Integer> getResultIndexes(int size) {
    return IntStream
        .range(0, size)
        .boxed()
        .collect(Collectors.toList());
  }
}
