package nextstep.ladder.src.domain;

import nextstep.ladder.src.MakeBridge;

public class Bridge {
  private final boolean isBridge;

  public Bridge(boolean isBridge) {
    this.isBridge = isBridge;
  }

  public Bridge(MakeBridge makeBridge) {
    this(makeBridge.make());
  }

  public boolean isBridge() {
    return isBridge;
  }
}
