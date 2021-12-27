package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HorizontalLineTest {

    @Test
    void 각_위치_이동() {
        // given
        int numberOfParticipant = 4;
        LineGenerator lineGenerator = new LineGenerator();
        HorizontalLine line = lineGenerator.generate(numberOfParticipant, () -> true);

        // then
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(3);
        assertThat(line.move(3)).isEqualTo(2);
    }
}