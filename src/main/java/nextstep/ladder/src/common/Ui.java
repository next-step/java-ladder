package nextstep.ladder.src.common;

import java.util.stream.Collectors;

import nextstep.ladder.src.domain.Floor;
import nextstep.ladder.src.domain.Ladder;
import nextstep.ladder.src.domain.Participants;

public class Ui {
  private static final String SPACE = "     ";

  private static final int STRING_SIZE = 5;

  private static final String bridge = "-----";
  private static final String notBridge = "     ";

  public Ui() {}

  public static String bridgeUi(boolean isBridge) {
    if(isBridge) {
      return bridge;
    }
    return notBridge;
  }

  public static String floorUi(Floor floor) {
    String str = floor.floor()
      .stream()
      .map(bridge -> bridgeUi(bridge.isBridge()))
      .collect(Collectors.joining("|"));
    return "|" + str + "|";
  }

  public static String ladderUi(Ladder ladder) {
    return ladder.ladder()
      .stream()
      .map(floor -> SPACE + floorUi(floor))
      .collect(Collectors.joining("\n"));
  }

  public static String participantsUi(Participants participants) {
    String users = participants.participants().stream()
      .map(user -> String.format("%" + STRING_SIZE + "s", user.name()))
      .collect(Collectors.joining(" "));
    return users;
  }
}
