package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {
    @Test
    @DisplayName("Points의 사이즈는 참가인원(CountOfPerson)보다 1 적어야 한다.")
    void createTest() {
        CountOfPerson countOfPerson = new CountOfPerson(4);
        Points points = new Points(countOfPerson);
        assertThat(points.size()).isEqualTo(countOfPerson.value - 1);
    }
}
