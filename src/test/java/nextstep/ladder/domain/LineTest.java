package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 라인_생성_테스트() {
        // given
        final int numberOfPeople = 4;

        // when
        final Line line = new Line(() -> true, numberOfPeople);

        // then
        assertThat(line.getPoints()).isEqualTo(List.of(true, false, true));
    }
}
