package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 게임 로직 테스트")
class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(new FixedLadderGenerator());
    }

    @DisplayName("사다리 게임의 결과를 확인할 수 있다.")
    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource(value = {"0,0", "1,3", "2,2", "3,1"}, delimiter = ',')
    public void get_gameResult_shouldSuccess(int x, int expected) {
        assertThat(ladder.getGameResult(x)).isEqualTo(expected);
    }

}
