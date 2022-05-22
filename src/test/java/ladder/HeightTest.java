package ladder;

import static ladder.Height.MIN_HEIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

  public static final Height HEIGHT_1 = new Height(5);

  @Test
  void Height_생성_성공() {
    assertDoesNotThrow(() -> new Height(MIN_HEIGHT));
  }

  @Test
  void Height_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new Height(MIN_HEIGHT - 1));
  }

  @DisplayName("Height(2)는 1보다 크기 때문에 True 반환")
  @Test
  void isMoreThan_성공() {
    Height height = new Height(2);

    assertThat(height.isMoreThan(1)).isTrue();
  }

  @ParameterizedTest(name = "Height(2)는 {0}보다 크지않기 때문에 False 반환")
  @ValueSource(ints = {2, 3})
  void isMoreThan_실패(int number) {
    Height height = new Height(2);

    assertThat(height.isMoreThan(number)).isFalse();
  }
}
