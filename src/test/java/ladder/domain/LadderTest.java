package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    List<String> countOfPerson = Arrays.asList("pobi", "hj", "seul", "hj2");

    @ParameterizedTest
    @DisplayName("사다리 높이 입력 성공 테스트")
    @ValueSource(ints = {2, 3, 4, 5})
    void 사다리_높이_입력_성공_테스트(int height) {

        Ladder ladder = Ladder.create(height, countOfPerson.size());
        assertThat(ladder.getLadder().size()).isEqualTo(Ladder.create(height, countOfPerson.size()).getLadder().size());
    }

    @ParameterizedTest
    @DisplayName("사다리 높이 입력 실패 테스트")
    @ValueSource(ints = {0, 1})
    void 사다리_높이_입력_실패_테스트(int height) {
        assertThatThrownBy(() -> Ladder.create(height, countOfPerson.size()))
                .isInstanceOf(RuntimeException.class);
    }

}
