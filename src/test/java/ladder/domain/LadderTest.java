package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {

    @ParameterizedTest(name = "사다리 생성 검증")
    @CsvSource(value = {"4,5"})
    void newLine(int lineSize, int heights) {

        Ladder ladder = new Ladder(lineSize, heights);

        assertThat(ladder.getLines().size()).isEqualTo(lineSize);
        assertThat(ladder.getHeight()).isEqualTo(heights);
    }

    @ParameterizedTest(name = "사다리 생성 시 Exception 발생. lineSize={0}, height={1}")
    @CsvSource(value = {
            "0,1",
            "-0,1",
            "1,0",
            "1,-1"
    })
    void newLineOccurredException(int lineSize, int heights) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(lineSize, heights));
    }
}