package ladder.step3.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

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
    participants.stream()
                .forEach(participant -> {
                  int x = offset[0];
                  int y = offset[1];
                  while (y < height) {
                    List<Boolean> nowLadder = shape.get(y);
                    y += 1;
                    if (x > 0 && nowLadder.get(x - 1)) {
                      x -= 1;
                      continue;
                    }
                    if (x < width && nowLadder.get(x)) {
                      x += 1;
                    }
                  }
                  offset[0] += 1;
                  resultMap.put(participant, resultList.get(x));
                });

    return new LadderGame(resultMap);
  }

  public LadderResult getResult (Participant participant) {
    validate(participant);
    return resultMap.get(participant);
  }

  public LadderResult getResult (String participant) {
    return getResult(Participant.valueOf(participant));
  }

  public Stream<Participant> stream () {
    return resultMap.keySet().stream();
  }

  private void validate (Participant participant) {
    if (resultMap.get(participant) == null) {
      throw new IllegalArgumentException("참여자에 포함된 사람이 아닙니다.");
    }
  }
}
