package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이 입력 성공 테스트")
    void 사다리_높이_입력_성공_테스트() {
        List<String> countOfPerson = Arrays.asList("pobi", "hj", "seul", "hj2");

        Ladder ladder = new Ladder(countOfPerson.size(), 3);
        assertThat(ladder.getLadder().size()).isEqualTo(new Ladder(countOfPerson.size(), 3).getLadder().size());
    }
}
