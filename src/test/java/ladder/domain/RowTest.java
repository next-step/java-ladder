package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class RowTest {
  @ParameterizedTest
  @MethodSource("provideWrongConstructorInput")
  void 연속된_line_있는_다리행_생성_불가(List<Boolean> input) {
    assertThatThrownBy(() -> Row.of(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 사다리 입력입니다.");
  }

  static Stream<List<Boolean>> provideWrongConstructorInput() {
    return Stream.of(
            List.of(true, true, true),
            List.of(true, true, false),
            List.of(false, true, true)
    );
  }

  @ParameterizedTest
  @MethodSource("provideRightConstructorInput")
  void 정상_다리_생성(List<Boolean> input) {
    Row.of(input);
  }

  static Stream<List<Boolean>> provideRightConstructorInput() {
    return Stream.of(
            List.of(false, false, false),
            List.of(false, false, true),
            List.of(false, true, false),
            List.of(true, false, false),
            List.of(true, false, true)
    );
  }

  @Test
  void generator_로_생성() {
    Row row = Row.fromGenerator(size -> Row.of(new int[]{0, 1, 0, 1}), 4);
    assertThat(row).isEqualTo(Row.of(List.of(false, true, false, true)));
  }

  @Test
  void 잘못된_generator_입력() {
    assertThatThrownBy(() -> Row.fromGenerator(size -> Row.of(new int[]{0, 1, 0, 1, 0}), 4))
            .isInstanceOf(IllegalStateException.class);
  }
}
