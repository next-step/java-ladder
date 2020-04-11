package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class LadderLineTest {

    @DisplayName("사다리 가로 라인 생성")
    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5,6})
    void create(int personSize) {
        assertThatCode(() -> LadderLine.of(personSize)).doesNotThrowAnyException();
    }

    @DisplayName("다음 라인으로 이동")
    @ParameterizedTest
    @ValueSource(ints = {2})
    void name(int personSize) {
        LadderLine ladderLine = LadderLine.of(personSize);
        int linePosition = ladderLine.move(0);

        assertThat(linePosition).isBetween(0, 1);
    }
}