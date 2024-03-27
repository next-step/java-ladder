package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 라인_생성_테스트() {
        // given
        final int numberOfPeople = 4;

        // when
        final Line line = new Line(numberOfPeople);

        // then
        assertThat(line.getPoints()).hasSize(3);
    }
}
