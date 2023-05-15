package ladder.domain;

import static ladder.domain.Line.lineOf;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import ladder.util.RandomPointStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    @DisplayName("1줄 이상의 라인이 입력 되었을 경우 객체가 생성된다.")
    void createObjTest() {
        assertDoesNotThrow(() -> new Lines(
                List.of(lineOf(1, new RandomPointStrategy()))));
    }

    @Test
    @DisplayName("라인이 비어있을경우 익셉션을 발생한다.")
    void emptyTest() {
        assertThatThrownBy(() -> new Lines(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 정보가 비어있습니다.");
    }

    @Test
    @DisplayName("데이터 수정이 일어날 경우 익셉션을 발생한다.")
    void immutableTest() {
        assertThatThrownBy(() -> new Lines(
                List.of(lineOf(1, new RandomPointStrategy())))
                .immutableGet().add(new Line(new ArrayList<>())))
                .isInstanceOf(IllegalArgumentException.class);
    }

}