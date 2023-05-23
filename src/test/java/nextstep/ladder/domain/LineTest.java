package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @DisplayName("한 명일 경우, 가로 라인을 갖지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1})
    public void Line_엣지_케이스_테스트(int countOfPerson) throws Exception {
        Line line = new Line(countOfPerson);
        assertThat(line.toList()).size().isEqualTo(0);
    }

    @DisplayName("Line 초기값은 양수여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -12, -22, 0})
    public void Line_예외_테스트(int countOfPerson) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(countOfPerson));
    }
}
