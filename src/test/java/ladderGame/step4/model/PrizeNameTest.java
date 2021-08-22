package ladderGame.step4.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeNameTest {

  @DisplayName("상품 객체 생성.")
  @ParameterizedTest
  @ValueSource(strings = {"꽝", "5000"})
  void create(String value) {
    assertThat(new PrizeName(value)).isEqualTo(new PrizeName(value));
  }

  @DisplayName("상품명 입력값 검증.")
  @ParameterizedTest
  @NullSource
  @EmptySource
  void invalidPrizeValue(String prize) {
    assertThatThrownBy(() -> new PrizeName(prize))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("입력된 상품명 최대 5자 검증.")
  @ParameterizedTest
  @CsvSource(value = {"prize1:prize", "가나다라마바:가나다라마"}, delimiter = ':')
  void invalidPrizeLength(String wrongPrize, String finePrize) {
    assertThatThrownBy(() -> new PrizeName(wrongPrize))
        .isInstanceOf(IllegalArgumentException.class);

    assertThat(new PrizeName(finePrize)).isNotNull();
  }
}