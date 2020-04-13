package nextstep.ladder.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {

  @DisplayName("Test for negative integer position")
  @ParameterizedTest
  @ValueSource(ints = {-3, -2, -1})
  public void IllegalalArgumentTest(int negative) {
    assertThatThrownBy(() -> Position.at(negative))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Test for isAdjacent method")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4})
  public void adjacentPositionTest(int position) {
    assertThat(Position.at(position).isAdjacent(Position.at(position + 1))).isTrue();
    assertThat(Position.at(position).isAdjacent(Position.at(position - 1))).isTrue();
  }

  @DisplayName("Test if \"at method\" returns same instance")
  @Test
  public void testSameInstance() {
    int position = 1;
    assertThat(Position.at(position) == Position.at(position)).isTrue();
  }
}
