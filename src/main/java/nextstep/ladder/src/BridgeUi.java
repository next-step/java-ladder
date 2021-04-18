package nextstep.ladder.src;

import java.util.Arrays;

public enum BridgeUi {
  TRUE(true, "-----"),
  FALSE(false, "     ");

  private final boolean isBridge;
  private final String ui;

  private BridgeUi(boolean isBridge, String ui) {
    this.isBridge = isBridge;
    this.ui = ui;
  }

  public static BridgeUi fromIsBridge(Bridge bridge) {
    return Arrays.stream(BridgeUi.values())
      .filter(bridgeUi -> bridgeUi.isBridge == bridge.isBridge())
      .findAny()
      .orElseThrow(() -> new IllegalArgumentException("사다리의 다리 생성 조건에 맞지 않는 값입니다."));
  }

  public String ui() {
    return ui;
  }
}
