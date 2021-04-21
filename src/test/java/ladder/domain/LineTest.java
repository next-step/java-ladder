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

  @Test
  @DisplayName("사다리 다음 라인을 생성한다. 현재 라인이 존재하면 Empty, " +
          "아니면 rule 결과에 맞게 생성한다.")
  void newNextLine() {
    // given
    Line frontOfDrawing = Line.generate(LineRule.drawing());
    Line frontOfEmpty = Line.generate(LineRule.empty());

    // when
    Line empty = frontOfDrawing.newNextLine(LineRule.drawing());
    Line drawing = frontOfEmpty.newNextLine(LineRule.drawing());

    // then
    assertAll(
            () -> assertThat(empty)
                    .isEqualTo(Line.generate(LineRule.empty())),
            () -> assertThat(drawing)
                    .isEqualTo(Line.generate(LineRule.drawing()))
    );
  }
}