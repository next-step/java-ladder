package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderTest {

  @DisplayName("입력한 너비와 높이를 갖는 사다리를 생성할 수 있다.")
  @Test
  void init() {
    Ladder ladder = Ladder.init(new Length(10), new Length(20));
    assertAll(
        () -> assertThat(ladder.getWidth()).isEqualTo(10),
        () -> assertThat(ladder.getHeight()).isEqualTo(20)
    );
  }

  @DisplayName("1보다 작은 너비나 높이가 입력되면 예외가 발생한다.")
  @Test
  void init_invalid() {
    assertThatThrownBy(() -> Ladder.init(new Length(0), new Length(0)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  /*
   1     2     3     4
   |     |-----|     |
   |     |     |-----|
   |-----|     |-----|
   1     2     3     4
*/
  @DisplayName("playerIndex를 입력하면 마지막 줄까지 이동하고 그곳의 인덱스를 반환한다.")
  @Test
  void move() {
    Ladder ladder = new Ladder(List.of(
        new LadderLine(List.of(
            Point.first(false),
            Point.first(false).next(true),
            Point.first(false).next(true).next(false),
            Point.first(false).next(true).next(false).last()
        )),
        new LadderLine(List.of(
            Point.first(false),
            Point.first(false).next(false),
            Point.first(false).next(false).next(true),
            Point.first(false).next(false).next(true).last()
        )),
        new LadderLine(List.of(
            Point.first(true),
            Point.first(true).next(false),
            Point.first(true).next(false).next(true),
            Point.first(true).next(false).next(true).last()
        ))
    ));

    assertAll(
        () -> assertThat(ladder.move(0)).isEqualTo(1),
        () -> assertThat(ladder.move(1)).isEqualTo(2),
        () -> assertThat(ladder.move(2)).isZero(),
        () -> assertThat(ladder.move(3)).isEqualTo(3)
    );
  }

  @DisplayName("유효하지 않은 인덱스를 입력하면 예외를 던진다.")
  @ParameterizedTest
  @ValueSource(ints = {-1, 5})
  void move_invalid(int invalidIndex) {
    Ladder ladder = Ladder.init(new Length(4), new Length(3));

    assertThatThrownBy(() -> ladder.move(invalidIndex)).isInstanceOf(IllegalArgumentException.class);
  }
}
