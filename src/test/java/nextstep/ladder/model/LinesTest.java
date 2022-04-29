package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("라인들")
class LinesTest {

    @Test
    @DisplayName("높이와 라인 생성기로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Lines.of(Positive.ONE, LineGenerator.of(Positive.ONE, Point::connected)));
    }

    @Test
    @DisplayName("높이와 라인 생성기는 필수")
    void instance_nullArguments_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lines.of(Positive.ONE, null));
        assertThatIllegalArgumentException().isThrownBy(() -> Lines.of(null, LineGenerator.of(Positive.ONE, Point::connected)));
    }
}
