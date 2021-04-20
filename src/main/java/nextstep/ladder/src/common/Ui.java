package nextstep.ladder.src.common;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.src.domain.Floor;
import nextstep.ladder.src.domain.Ladder;
import nextstep.ladder.src.domain.Participants;

public class Ui {
  private static final String SPACE = "   ";

  private final String bridge;
  private final String notBridge;

  public Ui(String bridge, String notBridge) {
    this.bridge = bridge;
    this.notBridge = notBridge;
  }

  public Ui(int size) {
    this(
      IntStream.range(0, size)
        .boxed()
        .map(i -> "-")
        .collect(Collectors.joining("")),
      IntStream.range(0, size)
        .boxed()
        .map(i -> " ")
        .collect(Collectors.joining(""))
    );
  }

  public String bridgeUi(boolean isBridge) {
    if(isBridge) {
      return bridge;
    }
    return notBridge;
  }

  public String floorUi(Floor floor) {
    String str = floor.floor()
      .stream()
      .map(bridge -> bridgeUi(bridge.isBridge()))
      .collect(Collectors.joining("|"));
    return "|" + str + "|";
  }

  public String ladderUi(Ladder ladder) {
    return ladder.ladder()
      .stream()
      .map(floor -> SPACE + SPACE + floorUi(floor))
      .collect(Collectors.joining("\n"));
  }

  public String participantsUi(Participants participants) {
    String users = participants.participants().stream()
      .map(user -> String.format("%" + (bridge.length() + 1) + "s", user.name()))
      .collect(Collectors.joining(""));
    return SPACE + users;
  }
}
