package ladder.impl;

import java.util.List;
import java.util.stream.Collectors;
import ladder.Ladder;
import ladder.PlayResults;

public class DefaultLadder implements Ladder {

  List<LadderLine> ladderLines;
  private int countOfPlayer;

  public DefaultLadder(List<LadderLine> ladderLines, int countOfPlayer) {
    this.ladderLines = ladderLines;
    this.countOfPlayer = countOfPlayer;
  }

  public static DefaultLadder of(List<LadderLine> ladderLines, int countOfPlayer) {
    return new DefaultLadder(ladderLines, countOfPlayer);
  }

  public int move(int position) {
    int currentPosition = position;
    for (int i = 0; i < ladderLines.size(); i++) {
      currentPosition = ladderLines.get(i).move(currentPosition);
    }
    return currentPosition;
  }

  @Override
  public String toString() {
    return ladderLines.stream()
        .map(LadderLine::toString)
        .collect(Collectors.joining(System.lineSeparator()));
  }

  @Override
  public PlayResults play() {
    LadderPlayResults ladderPlayResults = new LadderPlayResults();
    for (int i = 0; i < countOfPlayer; i++) {
      ladderPlayResults.add(LadderPlayResult.of(i, move(i)));
    }
    return ladderPlayResults;
  }

}
