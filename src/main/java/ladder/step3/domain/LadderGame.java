package ladder.step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class LadderGame {

  private final HashMap<Participant, LadderResult> resultMap;

  private LadderGame (HashMap<Participant, LadderResult> resultMap) {
    this.resultMap = resultMap;
  }

  public static LadderGame of (Ladder ladder, LadderResults results, Participants participants) {
    HashMap<Participant, LadderResult> resultMap = new HashMap<>();
    List<LadderResult> resultList = results.stream().collect(toList());
    List<List<Boolean>> shape = ladder.shape();
    int[] offset = { 0, 0 };
    int width = participants.size() - 1;
    int height = shape.size();

    participants
      .stream()
      .forEach(participant -> {
        int x = offset[0];
        int y = offset[1];
        while (y < height) {
          List<Boolean> nowLadder = shape.get(y);
          y += 1;
          if (x > 0) {
            x -= nowLadder.get(x - 1) ? 1 : 0;
            continue;
          }
          if (x < width) {
            x += nowLadder.get(x) ? 1 : 0;
            continue;
          }
        }
        offset[0] += 1;
        resultMap.put(participant, resultList.get(x));
      });

    return new LadderGame(resultMap);
  }

  public LadderResult getResult (Participant participant) {
    return resultMap.get(participant);
  }

  public static int getResultOffsetByParticipant (Participant participant, int[] offset) {
    return 0;
  }
}
