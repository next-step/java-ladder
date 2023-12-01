package ladder.domain;

import ladder.domain.Ladder;
import ladder.domain.LadderLine;
import ladder.domain.generator.RandomLadderLineGenerator;
import ladder.domain.type.ColumnConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static ladder.domain.type.ColumnConnection.CONNECTED;
import static ladder.domain.type.ColumnConnection.NOT_CONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    @DisplayName("[Ladder.of] 생성 테스트")
    public void creation() {
        assertThat(Ladder.of(
                List.of( "|-| | |", "| |-| |", "| | |-|"),
                '|', '-'
        )).isEqualTo(
                Ladder.of(
                        LadderLine.of(List.of(CONNECTED, NOT_CONNECTED, NOT_CONNECTED)),
                        LadderLine.of(List.of(NOT_CONNECTED, CONNECTED, NOT_CONNECTED)),
                        LadderLine.of(List.of(NOT_CONNECTED, NOT_CONNECTED, CONNECTED))
                )
        );
    }

    @Test
    @DisplayName("[Ladder.of] 사다리를 구성하는 사다리 라인 간 컬럼 개수가 다르면 -> 예외 던짐")
    public void differentColumn() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Ladder.of(
                            List.of( "| | | | |", "| | | |", "| | | | |"),
                            '|', '-'
                    );
                });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    @DisplayName("[LadderGenerator.of] 라인 생성기와 함께 depth를 지정해서 요청하면 -> 지정된 depth를 가진 Ladder 생성")
    public void ladderDepthTest(int depth) {
        Ladder ladder = Ladder.of(
                () -> LadderLine.of("|-|", '|', '-'),
                depth
        );

        assertThat(ladder.howLongDepth())
                .isEqualTo(depth);
    }

    @Test
    @DisplayName("[Ladder.calculateResultOf] 사다리 시작 컬럼 번호 주면 -> 그 컬럼의 도착 컬럼 반환")
    public void getResultTest() {
        Ladder ladder = Ladder.of(
                List.of(
                        "|-| | |",
                        "| |-| |",
                        "| | |-|"),
                '|',
                '-'
        );

        assertThat(ladder.calculateResultOf(0)).isEqualTo(3);
        assertThat(ladder.calculateResultOf(1)).isEqualTo(0);
        assertThat(ladder.calculateResultOf(2)).isEqualTo(1);
        assertThat(ladder.calculateResultOf(3)).isEqualTo(2);
    }
}
