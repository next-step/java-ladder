package ladder.domain;

import ladder.rule.LineRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

  @Test
  @DisplayName("사다리 라인을 조건에 맞게 생성한다. 라인이 존재하면 true, 없으면 false를 생성한다.")
  void generate() {
    // given

    // when
    Line create = Line.generate(LineRule.drawing());
    Line empty = Line.generate(LineRule.empty());

    // then
    assertAll(() -> assertThat(create.isEmpty()).isFalse(),
            () -> assertThat(empty.isEmpty()).isTrue());
  }
}