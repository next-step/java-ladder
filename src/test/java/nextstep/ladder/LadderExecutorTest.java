package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderExecutorTest {

  @Test
  @DisplayName("이름으로 사다리를 타고 결과를 조회할 수 있다.")
  void resultOf() {
    Participants participants = Participants.of(List.of("pobi", "honux", "jk"));
    Results results = new Results(List.of("꽝", "5000", "3000"));
    MappingTable table = new MappingTable(participants, results);

    Line line1 = new Line(List.of(true, false));
    Ladder ladder = new Ladder(List.of(line1));

    LadderExecutor executor = new LadderExecutor(ladder, table);

    assertThat(executor.execute("pobi")).isEqualTo("5000");
    assertThat(executor.execute("honux")).isEqualTo("꽝");
    assertThat(executor.execute("jk")).isEqualTo("3000");
  }

  @Test
  @DisplayName("모든 참가자의 결과를 Map으로 반환한다.")
  void allResults() {
    Participants participants = Participants.of(List.of("pobi", "honux", "jk"));
    Results results = new Results(List.of("꽝", "5000", "3000"));
    MappingTable table = new MappingTable(participants, results);
    Ladder ladder = new Ladder(List.of(new Line(List.of(true, false))));

    LadderExecutor executor = new LadderExecutor(ladder, table);
    Map<String, String> resultMap = executor.executeAll();

    assertThat(resultMap).containsEntry("pobi", "5000");
    assertThat(resultMap).containsEntry("honux", "꽝");
    assertThat(resultMap).containsEntry("jk", "3000");
  }

  @Test
  @DisplayName("참가자 이름이 존재하지 않으면 IllegalArgument 예외가 발생한다.")
  void invalidName_throwsException() {
    Participants participants = Participants.of(List.of("pobi", "honux"));
    Results results = new Results(List.of("꽝", "5000"));
    MappingTable table = new MappingTable(participants, results);
    Ladder ladder = new Ladder(List.of(new Line(List.of(false))));

    LadderExecutor executor = new LadderExecutor(ladder, table);

    assertThatIllegalArgumentException()
        .isThrownBy(() -> executor.execute("java"))
        .withMessageContaining("이름이 존재하지 않습니다");
  }

}
