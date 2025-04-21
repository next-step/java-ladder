package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  public void 선이_이전_위치에_있다면_현재_위치에는_선이_생기지_않는다() {
    PointGenerateStrategy pointGenerateStrategy = () -> true;
    Line line = new Line(2, pointGenerateStrategy);
    assertThat(line.generateNextLine(true, pointGenerateStrategy)).isFalse();
  }

  @Test
  public void 이전_위치에_선이_없고_전략값이_true면_선이_생긴다() {
    PointGenerateStrategy pointGenerateStrategy = () -> true;
    Line line = new Line(2, pointGenerateStrategy);
    assertThat(line.generateNextLine(false, pointGenerateStrategy)).isTrue();
  }

}
