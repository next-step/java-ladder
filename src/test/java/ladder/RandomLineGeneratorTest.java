package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLineGeneratorTest {

    @Test
    public void 참여자5명의_라인_생성() {
        // given
        int countOfPerson = 5;
        // when
        LineGenerator lineGenerator = new RandomLineGenerator();
        Line line = lineGenerator.generate(5);
        // then
        assertThat(line.getNumberOfPoints()).isEqualTo(countOfPerson);
    }
}
