package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("연속으로 라인이 생성되지 않는지 검사하는 테스트")
    @Test
    void check_points() {
        Line line = new Line(10);
        List<Boolean> result = new ArrayList<>();

        for(int i = 1; i < 4 ; i++) {
            result.add(line.getPoints().get(i-1) && line.getPoints().get(i));
        }

        assertThat(result).noneMatch(bool -> bool.equals(true));
    }
}
