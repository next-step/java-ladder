package ladder.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

  @Test
  void 생성() {
    assertThat(new Player("haha")).isEqualTo(new Player("haha"));
  }

  @Test
  void 이름은5자이상안됨() {
    assertThatIllegalArgumentException().isThrownBy(() ->{
      new Player("abcdef").toString();
    });
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = {"", " "})
  void 공백_널은_이름에_올수없습니다(String name) {
    assertThatIllegalArgumentException().isThrownBy(() ->{
      new Player(name);
    });
  }
}
