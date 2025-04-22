package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LineTest {

  PointGenerateStrategy pointGenerateStrategyTrue = () -> true;
  PointGenerateStrategy pointGenerateStrategyFalse = () -> false;

  @Test
  public void 선이_이전_위치에_있다면_현재_위치에는_선이_생기지_않는다() {

    Line line = new Line(2, pointGenerateStrategyTrue);
    assertThat(line.generateNextLine(true, pointGenerateStrategyTrue)).isFalse();
  }

  @Test
  public void 이전_위치에_선이_없고_전략값이_true면_선이_생긴다() {
    Line line = new Line(2, pointGenerateStrategyTrue);
    assertThat(line.generateNextLine(false, pointGenerateStrategyTrue)).isTrue();
  }

  @Test
  void 오른쪽_라인이_있으면_한칸_오른쪽으로_이동() {
    Line line = new Line(3, pointGenerateStrategyTrue);

    int nextIndex = line.move(0);

    assertThat(nextIndex).isEqualTo(1);
  }

  @Test
  void 왼쪽_라인이_있으면_한칸_왼쪽으로_이동() {
    Line line = new Line(3, pointGenerateStrategyTrue);

    int nextIndex = line.move(1);

    assertThat(nextIndex).isEqualTo(0);
  }

  @Test
  void 아무_라인이_없으면_그대로_유지() {
    Line line = new Line(3, pointGenerateStrategyFalse);

    int nextIndex = line.move(1);

    assertThat(nextIndex).isEqualTo(1);
  }

}
