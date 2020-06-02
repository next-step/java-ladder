package ladder.step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameExecutor {

  private final List<List<Boolean>> shape;

  private LadderGameExecutor (List<List<Boolean>> shape) {
    this.shape = shape;
  }

  public static Map<Participant, LadderResult> execute (
    Participants participants, LadderResults ladderResults, List<List<Boolean>> shape
  ) {
    return new LadderGameExecutor(shape).execute(participants, ladderResults);
  }

  private Map<Participant, LadderResult> execute (
    Participants participants, LadderResults ladderResults
  ) {
    Map<Participant, LadderResult> resultMap = new HashMap<>();
    int width = participants.size() - 1;
    for (int index = 0; index <= width; index++) {
      resultMap.put(
        participants.get(index),
        ladderResults.get(getResultIndex(index, width))
      );
    }
    return resultMap;
  }

  private int getResultIndex (int index, int width) {
    for (int y = 0, height = shape.size(); y < height; y++) {
      if (index > 0 && shape.get(y).get(index - 1)) {
        index -= 1; continue;
      }
      if (index < width && shape.get(y).get(index)) {
        index += 1;
      }
    }
    return index;
  }
}
