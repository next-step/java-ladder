package nextstep.step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameEngine {

  private GameParticipants gameParticipants;
  private List<Line> lines;
  private String[] ladderGameResults;

  public LadderGameEngine(GameParticipants gameParticipants, List<Line> lines,
      String ladderGameResultStr) {
    this.gameParticipants = gameParticipants;
    this.lines = lines;
    this.ladderGameResults = ladderGameResultStr.split(",");
  }

  public LadderGameResult execute() {

    Map<Participant, String> ladderGameResultMap = new HashMap<>();

    for (int i = 0; i < gameParticipants.getParticipantsSize(); i++) {
      Participant participant = gameParticipants.getGameParticipants(i);

      String ladderGameResult = searchLine(i);

      ladderGameResultMap.put(participant, ladderGameResult);
    }

    return new LadderGameResult(ladderGameResultMap);
  }

  private String searchLine(int currentIndex) {
    for (int i = 0; i < lines.size(); i++) {
      Line line = lines.get(i);
      if (!line.getPoint(currentIndex)) {
        continue;
      }

      currentIndex = moveHorizontal(currentIndex, line);
    }

    return ladderGameResults[currentIndex];
  }

  private int moveHorizontal(int currentIndex, Line line) {

    int newIndex = currentIndex;

    if (currentIndex > 0 && line.getPoint(currentIndex - 1)) {
      newIndex = currentIndex - 1;
    }

    if (currentIndex + 1 < line.getPointSize() && line.getPoint(currentIndex + 1)) {
      newIndex = currentIndex + 1;
    }

    return newIndex;
  }
}
