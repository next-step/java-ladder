package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderLine;
import ladder.domain.generator.RandomLadderLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    @DisplayName("[Ladder.of] 생성 테스트")
    public void creation() {
        assertThat(Ladder.of(
                "|-| | |",
                "| |-| |",
                "| | |-|"
        )).isEqualTo(
                Ladder.of(
                        LadderLine.of(List.of(true, false, false)),
                        LadderLine.of(List.of(false, true, false)),
                        LadderLine.of(List.of(false, false, true))
                )
        );
    }

    @Test
    @DisplayName("[Ladder.of] 사다리를 구성하는 사다리 라인 간 컬럼 개수가 다르면 -> 예외 던짐")
    public void differentColumn() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    Ladder.of(
                            "| | | | |",
                            "| | | |",
                            "| | | | |"
                    );
                });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    @DisplayName("[LadderGenerator.of] 라인 생성기와 함께 depth를 지정해서 요청하면 -> 지정된 depth를 가진 Ladder 생성")
    public void ladderDepthTest(int depth) {
        Ladder ladder = Ladder.of(
                () -> LadderLine.of("|-|"),
                depth
        );

        assertThat(ladder.howLongDepth())
                .isEqualTo(depth);
    }
}
