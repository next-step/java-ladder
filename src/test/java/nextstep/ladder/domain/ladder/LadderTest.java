package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.person.People;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.util.RandomConnectStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("사다리의 높이, 참여 인원, 연결 전략을 입력하면 사다리가 생성된다.")
    @Test
    void createLadderTest() {
        Ladder ladder = Ladder.from(5, People.from("pobi,honux,crong,jk,abc"), new RandomConnectStrategy());
        System.out.println(ladder);
    }

    @DisplayName("사다리의 높이가 1보다 작으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void createLadderTestFail(int height) {
        assertThatThrownBy(() -> Ladder.from(height, People.from("pobi,honux,crong,jk,abc"), new RandomConnectStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리에 결과 문자열을 넘겨 결과 목록을 생성한다.")
    @Test
    void resultsTest() {
        People people = People.from("pobi,honux,crong,jk,abc");
        Ladder ladder = Ladder.from(5, people, new RandomConnectStrategy());
        ladder.results("꽝,5000,꽝,3000,20000");
    }

    @DisplayName("사다리에 결과 문자열을 넘겨 결과 목록을 생성한다. 사다리의 한 행의 길이와 결과의 길이가 다르면 예외가 발생한다.")
    @Test
    void resultsTestFail() {
        Ladder ladder = Ladder.from(5, People.from("pobi,honux,crong,jk,abc"), new RandomConnectStrategy());
        assertThatThrownBy(() -> ladder.results("꽝,5000,꽝,3000,20000,꽝"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
