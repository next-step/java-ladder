package nextstep.ladder.src;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BridgeUiTest {

  @ParameterizedTest
  @MethodSource("bridgeUiArguments")
  @DisplayName("bridge ui test")
  public void bridgeUi(Bridge bridge, String ui) {
    String str = BridgeUi.fromIsBridge(bridge).ui();

    assertThat(str).isEqualTo(ui);
  }

  private static Stream<Arguments> bridgeUiArguments() {
    return Stream.of(
      Arguments.of(
        new Bridge(true),
        "-----"
      ),
      Arguments.of(
        new Bridge(false),
        "     "
      )
    );
  }
}
