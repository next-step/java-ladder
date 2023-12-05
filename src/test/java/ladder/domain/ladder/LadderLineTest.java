package ladder.domain.ladder;

import ladder.domain.ladder.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static ladder.domain.ladder.LadderConnection.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderLineTest {
    @Test
    @DisplayName("[LadderLine.howManyColumns()] 컬럼 4개짜리면 -> 4 반환")
    public void columnTest() {
        assertThat(LadderSampleData.lineA.howManyColumns()).isEqualTo(4);
    }

    @Test
    @DisplayName("[LadderLine.new] 인데스 순서 꼬임 -> 예외 던짐")
    public void newTest() {
        /*
        |-| | | 꼴의 정상 사다리 라인이나 인덱스 순서가 꼬임
         */
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new LadderLine(
                            List.of(
                                    new LadderColumn(1, LEFT),
                                    new LadderColumn(0, RIGHT),
                                    new LadderColumn(2, NONE),
                                    new LadderColumn(3, NONE)
                            )
                    );
                });
    }

    @Test
    @DisplayName("[LadderLine.new] 분기점이 두 곳인 컬럼이 있을 경우 -> 예외 던짐")
    public void twoMovePoint() {
        /*
        |-|-| | 꼴의 테스트. 불가능한 사다리임
         */
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new LadderLine(List.of(
                            new LadderColumn(0, RIGHT),
                            new LadderColumn(1, RIGHT),
                            new LadderColumn(2, LEFT),
                            new LadderColumn(3, NONE)
                    ));
                });
    }

    @Test
    @DisplayName("[LadderLine.connectedColumnOf] 컬럼 번호 주면 -> 그 컬럼에서 이어진 컬럼 번호 반환")
    public void connectedColumnOf() {
        /*
        |-| | | 꼴의
         */
        LadderLine ladderLine = new LadderLine(
                List.of(
                        new LadderColumn(0, RIGHT),
                        new LadderColumn(1, LEFT),
                        new LadderColumn(2, NONE),
                        new LadderColumn(3, NONE)
                )
        );

        assertThat(ladderLine.connectedColumnOf(0)).isEqualTo(1);
        assertThat(ladderLine.connectedColumnOf(1)).isEqualTo(0);
        assertThat(ladderLine.connectedColumnOf(2)).isEqualTo(2);
        assertThat(ladderLine.connectedColumnOf(3)).isEqualTo(3);
    }
}