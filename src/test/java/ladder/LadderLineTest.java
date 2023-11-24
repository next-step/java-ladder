package ladder;

import nextstep.ladder.LadderLine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThat(LadderLine.of("| |-| |"))
                .isEqualTo(LadderLine.of(
                        List.of(false, true, false)
                ));
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