package nextstep.ladder.ui;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LadderRendererTest {

  @Test
  void printCenter() {
    assertThat(LadderRenderer.center("abc")).isEqualTo("   abc   ");
    assertThat(LadderRenderer.center("abcd")).isEqualTo("  abcd   ");
  }

}