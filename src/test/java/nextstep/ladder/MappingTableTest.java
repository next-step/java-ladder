package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MappingTableTest {
  @Test
  @DisplayName("정상적으로 이름, 인덱스, 결과 매핑이 가능하다.")
  void mapping_success() {
    Participants participants = Participants.of(List.of("pobi", "honux", "jk"));
    Results results = new Results(List.of("꽝", "5000", "3000"));

    MappingTable table = new MappingTable(participants, results);

    assertThat(participants.indexOf("pobi").orElse(-1)).isEqualTo(0);
    assertThat(results.get(1)).isEqualTo("5000");
    assertThat(participants.names()).containsExactly("pobi", "honux", "jk");
  }

  @Test
  @DisplayName("이름이 존재하지 않으면 IllegalArgument 예외가 발생한다.")
  void nameNotFound() {
    Participants participants = Participants.of(List.of("pobi", "honux"));
    Results results = new Results(List.of("꽝", "5000"));
    MappingTable table = new MappingTable(participants, results);

    assertThatIllegalArgumentException()
        .isThrownBy(() -> table.indexOf("java"))
        .withMessageContaining("이름이 존재하지 않습니다");
  }

  @Test
  @DisplayName("참가자 수와 결과 수가 다르면 IllegalArgument 예외가 발생한다.")
  void mismatchedSize() {
    Participants participants = Participants.of(List.of("pobi", "honux"));
    Results results = new Results(List.of("꽝"));

    assertThatIllegalArgumentException()
        .isThrownBy(() -> new MappingTable(participants, results))
        .withMessageContaining("참가자 수와 결과 수는 같아야 합니다.");
  }
}
