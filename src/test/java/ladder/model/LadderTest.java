package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    int height = 5;
    int width = 4;

    //when
    Ladder ladder = new Ladder(5, 4);

    //then
    assertThat(ladder.getHeight()).isEqualTo(height);
    assertThat(ladder.getWidth()).isEqualTo(width);
  }

  @ParameterizedTest(name = "잘못된 생성 테스트 height:{0}, width:{1}")
  @CsvSource(value = {"0, 4", "5, 0", "-1, 0"})
  void invalidCreateTest(int height, int width) {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new Ladder(height, width);
    });
  }
}
