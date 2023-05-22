package nextstep.ladder.domain;

import jdk.jfr.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1000, 1000"
    })
    @Description(value = "왼쪽으로도 오른쪽으로 건널 수 있는 다리는 생성되지 않음")
    void 사다리_확인(int height, int people) {
        Ladder ladder = Ladder.createLadder(people, height, () -> new Random().nextBoolean());
        ladder.getLines()
                .forEach(line -> {
                    List<Boolean> bridges = line.getBridges();
                    assertThat(bridges).hasSize(people - 1);
                    assertThat(line.isValidBridge()).isTrue();
                });
    }


    public static Stream<Arguments> createSimpleLadder() {
        return Stream.of(
                /**
                 * users -> [a][b][c][d][e]
                 * lines ->  |--|  |--|  |
                 *           |--|  |--|  |
                 *           |--|  |--|  |
                 *           |--|  |--|  |
                 *           |--|  |--|  |
                 * result ->[b][a][d][c][e]
                 */
                Arguments.of(Ladder.createLadder(5, 5, () -> true))
        );
    }

    @ParameterizedTest
    @MethodSource(value = "createSimpleLadder")
    void 다리_이동_테스트(Ladder ladder) {
        assertThat(ladder.findLastPosition(0)).isEqualTo(1);
        assertThat(ladder.findLastPosition(1)).isEqualTo(0);
        assertThat(ladder.findLastPosition(2)).isEqualTo(3);
        assertThat(ladder.findLastPosition(3)).isEqualTo(2);
        assertThat(ladder.findLastPosition(4)).isEqualTo(4);
    }
}