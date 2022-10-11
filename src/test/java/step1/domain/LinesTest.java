package step1.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class LinesTest {

    @Test
    @DisplayName("입력받은 라인의 길이가 동일하지 않으면 에러 발생")
    void validateHeightSame() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> Lines.from(List.of(
                Line.from(List.of(new Bridge(false), new Bridge(false))),
                Line.from(List.of(new Bridge(true))))
            )
        );
    }

    @Test
    @DisplayName("첫번째 Line의 모든 Bridge들이 닫혀있지 아니면 에러 발생.")
    void validateFirstLineIsAllFalse() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> Lines.from(List.of(
                Line.from(List.of(new Bridge(true), new Bridge(false))))
            )
        );
    }

    @Test
    @DisplayName("양 옆으로 인접한 Bridge가 열려있으면 에러 발생.")
    void validateBridgesDuplicated() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> Lines.from(List.of(
                Line.from(List.of(new Bridge(false), new Bridge(false))),
                Line.from(List.of(new Bridge(true), new Bridge(false))),
                Line.from(List.of(new Bridge(true), new Bridge(false))))
            )
        );
    }

    @Test
    @DisplayName("lines 정상 생성 테스트")
    void createLines() {
        then(Lines.from(List.of(
                Line.from(List.of(new Bridge(false), new Bridge(false), new Bridge(false))),
                Line.from(List.of(new Bridge(true), new Bridge(false), new Bridge(true))),
                Line.from(List.of(new Bridge(false), new Bridge(true), new Bridge(false))))
            )
        ).isInstanceOf(Lines.class);
    }
}