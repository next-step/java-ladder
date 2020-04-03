package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {

    @Test
    public void generateLine() throws Exception {
        //given
        LadderGenerator ladderGenerator = new LadderGenerator(3, 3);

        //when
        Line line = ladderGenerator.generateLine();

        //then
        assertThat(line.size()).isEqualTo(3);
    }
}
