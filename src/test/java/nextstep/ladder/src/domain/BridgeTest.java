package nextstep.ladder.src.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

  @Test
  @DisplayName("bridge construct test")
  public void construct() {
    Bridge bridged = new Bridge(() -> true);
    Bridge notBridged = new Bridge(() -> false);
    
    assertThat(bridged.isBridge()).isTrue();
    assertThat(notBridged.isBridge()).isFalse();
  }
}
