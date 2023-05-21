package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderResultTest {

    private Participants participants;
    private List<String> results;

    @BeforeEach
    void setUp() {
        this.participants = new Participants(List.of("pobi", "honux", "crong", "jk"));
        this.results = List.of("꽝", "5000", "꽝", "3000");
    }

    @DisplayName("사다리 실행 결과를 입력 받을 때, 참여자 수와 같으면 예외를 발생하지 않는다.")
    @Test
    void name() {
        assertThatNoException()
                .isThrownBy(() -> LadderResult.of(participants, results));
    }

    @DisplayName("사다리 실행 결과를 입력 받을 때, 참여자 수와 같지 않으면 예외를 발생한다.")
    @Test
    void name2() {
        List<String> results = List.of("꽝", "5000", "꽝", "3000", "10000");
        assertThatThrownBy(() -> LadderResult.of(participants, results))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("index를 호출 하면 해당 리스트의 인덱스를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void dummy(int index) {
        LadderResult result = LadderResult.of(participants, results);
        assertThat(result.get(index)).isEqualTo(results.get(index));
    }
}