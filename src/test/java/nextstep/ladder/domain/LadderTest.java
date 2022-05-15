package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  @DisplayName("생성자로 ladder를 생성한다.")
  @Test
  void createByConstructor() {
    List<Line> lineList = List.of(
        Line.create(2, HalfRateGeneratingStrategy.getInstance()),
        Line.create(3, HalfRateGeneratingStrategy.getInstance())
    );

    Ladder ladder = new Ladder(lineList);

    assertThat(ladder).isNotNull().isInstanceOf(Ladder.class);
  }

  @DisplayName("정적 팩터리 메서드로 ladder를 생성한다.")
  @Test
  void createByFactoryMethod() {
    Ladder ladder = Ladder.of(new Length(2), new Length(3));
    assertThat(ladder).isNotNull().isInstanceOf(Ladder.class);
  }

  @DisplayName("입력한 너비와 높이를 갖는 사다리를 생성할 수 있다.")
  @Test
  void createWithValues() {
    Ladder ladder = Ladder.of(new Length(10), new Length(20));
    assertAll(
        () -> assertThat(ladder.getWidth()).isEqualTo(10),
        () -> assertThat(ladder.getHeight()).isEqualTo(20)
    );
  }

  @DisplayName("1보다 작은 너비나 높이가 입력되면 예외가 발생한다.")
  @Test
  void create_실패() {
    assertThatThrownBy(() -> Ladder.of(new Length(0), new Length(0)))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
