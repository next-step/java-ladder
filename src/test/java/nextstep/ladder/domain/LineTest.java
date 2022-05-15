package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

  @DisplayName("생성자로 Line을 생성한다.")
  @Test
  void createByConstructor() {
    List<Boolean> booleans = List.of(false, true, false, true);
    Line line = new Line(booleans);
    assertThat(line).isNotNull().isInstanceOf(Line.class);
  }

  @DisplayName("정적 팩터리 메서드로 Line을 생성한다.")
  @Test
  void createByFactoryMethod() {
    Line line = Line.create(10, HalfRateGeneratingStrategy.getInstance());
    assertThat(line).isNotNull().isInstanceOf(Line.class);
  }

  @DisplayName("입력된 너비 만큼의 좌표를 가진 Line을 생성할 수 있다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 10, 100})
  void create(int width) {
    Line line = Line.create(width, HalfRateGeneratingStrategy.getInstance());
    assertThat(line.size()).isEqualTo(width);
  }

  @DisplayName("이전 좌표에 선이 있으면, 현재 좌표에는 선이 존재할 수 없다.")
  @Test
  void getBoolean() {
    assertThat(Line.checkLineByPrevious(true, HalfRateGeneratingStrategy.getInstance())).isFalse();
  }

  @DisplayName("Boolean 생성 전략을 조절할 수 있다.")
  @Test
  void createWithAllTruePoints() {
    Line line = Line.create(5, () -> false);
    assertThat(line.getPoints()).containsOnly(false);
  }
}
