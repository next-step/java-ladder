package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("라인들")
class LinesTest {

    @Test
    @DisplayName("높이와 라인 생성기로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Lines.of(Positive.ONE, LineGenerator.of(Positive.ONE, () -> Point.CONNECTED)));
    }

    @Test
    @DisplayName("높이와 라인 생성기는 필수")
    void instance_nullArguments_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lines.of(Positive.ONE, null));
        assertThatIllegalArgumentException().isThrownBy(() -> Lines.of(null, LineGenerator.of(Positive.ONE, () -> Point.CONNECTED)));
    }

    @Test
    @DisplayName("라인 생성기에서 주어진 높이 수대로 라인 반환")
    void list() {
        assertThat(Lines.of(Positive.ONE, LineGenerator.of(Positive.ONE, () -> Point.CONNECTED)).list())
                .hasSize(1)
                .containsExactly(Line.from(Collections.singletonList(Point.CONNECTED)));
    }

    @Test
    @DisplayName("연결이 무조건 안되면 처음과 마지막 index 는 동일")
    void lastIndexMoved() {
        //given
        int startIndex = 0;
        //when, then
        assertThat(Lines.of(Positive.from(3), LineGenerator.of(Positive.from(3), () -> Point.DISCONNECTED)).lastMovedIndex(startIndex))
                .isEqualTo(startIndex);
    }
}
