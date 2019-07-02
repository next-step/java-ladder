package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {

    @ParameterizedTest(name = "사다리 생성 검증")
    @CsvSource(value = {"4,5"})
    void newLine(int width, int height) {

        Ladder ladder = new Ladder(LadderInfo.of(width, height));

        assertThat(ladder.getLadderInfo().getWidth()).isEqualTo(width);
        assertThat(ladder.getLadderInfo().getHeight()).isEqualTo(height);
    }

    @ParameterizedTest(name = "사다리 생성 시 Exception 발생. width={0}, height={1}")
    @CsvSource(value = {
            "0,1",
            "-0,1",
            "1,0",
            "1,-1"
    })
    void newLineOccurredException(int width, int height) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(LadderInfo.of(width, height)));
    }
}