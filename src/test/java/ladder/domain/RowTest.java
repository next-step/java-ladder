package ladder.domain;

import ladder.rowgenerator.RowGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RowTest {
  @Test
  void 연속된_line_있는_다리행_생성_불가() {
    assertThatThrownBy(() -> Row.of(List.of(false, true, true, false)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("잘못된 사다리 입력입니다.");
  }

  @Test
  void generator_로_생성() {
    Row row = Row.fromGenerator(new RowGenerator() {
      @Override
      public Row generate() {
        return Row.of(new int[]{0, 1, 0, 1});
      }
    });
    assertThat(row).isEqualTo(Row.of(List.of(false, true, false, true)));
  }
}
