package ladder;

import ladder.domain.LadderLine;
import ladder.domain.type.ColumnConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.type.ColumnConnection.CONNECTED;
import static ladder.domain.type.ColumnConnection.NOT_CONNECTED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderLineTest {
    @Test
    @DisplayName("[LadderLine.of] 사다리 한 줄 생성")
    public void creation() {
        assertThat(LadderLine.of("|-| | |"))
                .isEqualTo(LadderLine.of("|-| | |"));
    }

    @Test
    @DisplayName("[LadderLine.of] 문자열 생성과 bool 배열 생성 간의 일치")
    public void creationWithTwoMethod() {
        LadderLine ladderLineByString = LadderLine.of("| |-| |");
        LadderLine ladderLineByConnection = LadderLine.of(
                List.of(NOT_CONNECTED, CONNECTED, NOT_CONNECTED)
        );

        assertThat(ladderLineByString)
                .isEqualTo(ladderLineByConnection);
    }

    @Test
    @DisplayName("[LadderLine.of] 분기점이 두 곳인 컬럼이 있을 경우 -> 예외 던짐")
    public void twoMovePoint() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    LadderLine.of("| |-|-| |");
                });
    }
}