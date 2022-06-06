package ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {

  public static final List<Prize> PRIZE_LIST_1 = Stream.of("1", "2", "3", "4", "5")
      .map(Prize::new)
      .collect(Collectors.toUnmodifiableList());

  @ParameterizedTest(name = "{0}으로 Prize 생성 성공")
  @ValueSource(strings = {"a", "bb", "ccc", "dddd", "eeeee"})
  void Prize_생성_성공(String validPrize) {
    assertDoesNotThrow(() -> new Prize(validPrize));
  }

  @Test
  void equals_성공() {
    assertThat(new Prize("test")).isEqualTo(new Prize("test"));
  }

  @ParameterizedTest(name = "{0}으로 Prize 생성 실패")
  @ValueSource(strings = {"", " ", "123456"})
  void Prize_생성_실패(String invalidPrize) {
    assertThrows(IllegalArgumentException.class, ()-> new Prize(invalidPrize));
  }

  @ParameterizedTest(name = "{0}으로 toString 성공")
  @ValueSource(strings = {"a", "bb", "ccc", "dddd", "eeeee"})
  void toString_성공(String rawPrize) {
    Prize Prize = new Prize(rawPrize);
    assertThat(Prize.toString()).isEqualTo(rawPrize);
  }
}
