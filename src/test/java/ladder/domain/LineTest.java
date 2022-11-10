package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {

    @Test
    @DisplayName("4개의 line이 생성되었을때 line의 생성시 직전값이 true일때는 반드시 false인지 확인한다.")
    void createLineTest() {

        int userCount = 10;

        Line line = new Line(userCount);
        List<Boolean> points = line.getPoints();
        assertAll(() -> {
           for (int i = 0; i< points.size() -1; i++) {

               assertThat(assertPoint(i, points)).isTrue();
           }
        });
    }

    private boolean assertPoint(int i, List<Boolean> points) {
        return !points.get(i) || !points.get(i + 1);
    }
}
