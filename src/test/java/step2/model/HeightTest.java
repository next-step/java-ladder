package step2.model;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.error.InvalidHeightException;

class HeightTest {
  @ParameterizedTest
  @ValueSource(ints = {1,5,7})
  @DisplayName("높이 생성 성공")
  void validHeightMakeTest(int heightKey){
    Height height = new Height(heightKey);

    assertThat(height.height()).isEqualTo(heightKey);
  }

  @ParameterizedTest
  @ValueSource(ints = {-1,0})
  @DisplayName("높이 생성 실패")
  void inValidHeightMakeTest(int heightKey){
    assertThatThrownBy(() -> new Height(heightKey))
      .isInstanceOf(InvalidHeightException.class)
      .hasMessage("최소 높이보다 낮습니다.");

  }
}