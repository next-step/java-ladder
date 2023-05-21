package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 6, 10})
    public void Line_생성_테스트(int countOfPerson) throws Exception {
        Line line = new Line(countOfPerson);
        List<Boolean> booleans = line.toList();

        assertThat(booleans)
                .containsOnly(Boolean.TRUE, Boolean.FALSE);
    }

    @DisplayName("가로 라인 겹칠 수 없다. ex. |-----|-----|")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 6, 10})
    public void Line_규칙_테스트(int countOfPerson) throws Exception {
        Line line = new Line(countOfPerson);
        List<Boolean> points = line.toList();

        for (int i = 1; i < points.size(); i++) {
            int previous = i - 1;
            assertThat(isValidLine(points.get(previous), points.get(i))).isTrue();
            assertThat(points.get(i)).isInstanceOf(Boolean.class);
        }
    }

    private boolean isValidLine(Boolean previousValue, Boolean nowValue) {
        return !(previousValue && nowValue);
    }

}
