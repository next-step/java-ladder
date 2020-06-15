package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Height;
import step2.domain.Lines;
import step2.domain.Point;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @ParameterizedTest
    @DisplayName("사람수, 높이 지정 후 사다리 출력 갯수 테스트")
    @CsvSource(value = {"5:3:15", "6:2:12", "5:4:20"}, delimiter = ':')
    void countVerticalLineTest(int height, int countOfperson, int totalLadderBar){
        Height heightObj = Height.of(height);
        Lines lines = Lines.createVertical(heightObj,countOfperson);
        List<Point> ladder = lines.createHorizontal();
        assertThat(ladder).hasSize(totalLadderBar);
    }
}
