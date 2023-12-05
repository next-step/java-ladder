package ladder.domain.ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static ladder.domain.ladder.LadderConnection.NONE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    @DisplayName("[Ladder.new] 사다리를 구성하는 사다리 라인 간 컬럼 개수가 다르면 -> 예외 던짐")
    public void differentColumn() {
        LadderLine line1 = new LadderLine(
                List.of(
                        new LadderColumn(0, NONE),
                        new LadderColumn(1, NONE),
                        new LadderColumn(2, NONE)
                )
        );

        LadderLine line2 = new LadderLine(
                List.of(
                        new LadderColumn(0, NONE),
                        new LadderColumn(1, NONE),
                        new LadderColumn(2, NONE),
                        new LadderColumn(3, NONE)
                )
        );

        /*
        | | |
        | | | |
        꼴의 불가능한 사다리
         */
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Ladder(
                            List.of(
                                    line1,
                                    line2
                            )
                    );
                }
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    @DisplayName("[LadderGenerator.of] 라인 생성기와 함께 depth를 지정해서 요청하면 -> 지정된 depth를 가진 Ladder 생성")
    public void ladderDepthTest(int depth) {
        Ladder ladder = Ladder.of(
                () -> LadderSampleData.lineA,
                depth
        );

        assertThat(ladder.howLongDepth())
                .isEqualTo(depth);
    }

    @Test
    @DisplayName("[Ladder.calculateResultOf] 사다리 시작 컬럼 번호 주면 -> 그 컬럼의 도착 컬럼 반환")
    public void getResultTest() {
        Ladder ladder = LadderSampleData.ladder;

        assertThat(ladder.calculateResultOf(0)).isEqualTo(3);
        assertThat(ladder.calculateResultOf(1)).isEqualTo(0);
        assertThat(ladder.calculateResultOf(2)).isEqualTo(1);
        assertThat(ladder.calculateResultOf(3)).isEqualTo(2);
    }
}
