package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    @DisplayName("참여자 만큼 라인 포인트 생성")
    public void createLinePointTest(int countOfPerson) throws Exception {
        // given

        // when
        Line line = new Line(countOfPerson);
        int size = line.readOnlyPoints().size();

        // then
        assertThat(size).isEqualTo(countOfPerson);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1})
    @DisplayName("참여자 2명 미만 일시 에러")
    public void personTwoUnderException(int countOfPerson) throws Exception {
        // given

        // when
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Line(countOfPerson);
        });

        // then
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4})
    @DisplayName("마지막 포인트는 false 로 끝나야 한다.")
    public void isLastPointFalseTest(int countOfPerson) throws Exception {
        // given

        // when
        Line line = new Line(countOfPerson);
        List<Boolean> points = line.readOnlyPoints();

        // then
        assertThat(points.get(points.size()-1)).isFalse();
    }

    @Test
    @DisplayName("모든 포인트 False 확인")
    public void allPointFalseTest() throws Exception {
        // given
        Line line = new Line(5, () -> false);

        // when
        boolean result = line.readOnlyPoints().stream()
                .noneMatch(p -> p);

        // then
        assertThat(result).isTrue();
    }
}
