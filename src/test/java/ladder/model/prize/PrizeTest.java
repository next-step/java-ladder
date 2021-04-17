package ladder.model.prize;

import ladder.error.InvalidPrizeFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PrizeTest {
  @ParameterizedTest
  @ValueSource(strings = {"꽝", "1000", "2000"})
  @DisplayName("생성 가능할 때 생성")
  void validMakeTest(String prize){
    Prize validPrize =new Prize(prize);

    assertThat(validPrize.prize()).isEqualTo(prize);
  }

  @ParameterizedTest
  @ValueSource(strings = {"깡", "a122", "32a"})
  @DisplayName("생성 불가능할 때 생성")
  void invalidMakeTest(String prize){
    assertThatThrownBy(() ->
      new Prize(prize)
    ).isInstanceOf(InvalidPrizeFormatException.class)
      .hasMessage("잘못된 결과를 입력했습니다.");
  }

}