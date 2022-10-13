package step4;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Bridge;
import step4.domain.Line;
import step4.domain.Lines;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LinesTest {

    @Test
    @DisplayName("lines의 높이가 모두 같은지 검증")
    void validateHeightSame() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> Lines.from(List.of(
                Line.from(List.of(new Bridge(false))),
                Line.from(List.of(new Bridge(true), new Bridge(true))))
            )
        );
    }

    @Test
    @DisplayName("첫번째 라인의 Bridges가 모두 닫혀있는지 테스트")
    void validateFirstLineIsAllClosed() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> Lines.from(List.of(
                Line.from(List.of(new Bridge(true))))
            )
        );
    }

    @Test
    @DisplayName("line의 양쪽 Bridge가 모두 열려있으면 에러 발생.")
    void validateDuplicatedBridge() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> Lines.from(List.of(
                Line.from(List.of(new Bridge(false), new Bridge(false))),
                Line.from(List.of(new Bridge(true), new Bridge(false))),
                Line.from(List.of(new Bridge(true), new Bridge(false))))
            )
        );
    }
}