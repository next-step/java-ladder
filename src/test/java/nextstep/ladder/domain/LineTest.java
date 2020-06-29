package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("Line 생성 시 사람 수 만큼의 point 가 생성 되어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void linePointCountTest(int countOfPerson){
        // when
        Line line = new Line(countOfPerson, (point) -> true);

        // then
        assertThat(line.getPoints()).hasSize(countOfPerson);
    }

    @DisplayName("Line 생성 시 point 는 true 가 연속으로 생성될 수 없다")
    @Test
    void lineDuplicateTruePointTest(){
        // given
        int countOfPerson = 3;
        Line line = new Line(countOfPerson, new RandomPointStrategy());
        List<Boolean> points = line.getPoints();

        // when
        for (int i = 0; i < points.size(); i++) {
            boolean isLine = points.get(i);

            if (isLine) {
                boolean previous = points.get(i - 1);

                assertThat(previous).isFalse();
            }
        }
    }
}
