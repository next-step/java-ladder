package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    private static Ladder ladder;

    @BeforeAll
    static void setUp() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(true, false)));
        lines.add(new Line(Arrays.asList(false, false)));
        ladder = new Ladder(lines);
    }


    @DisplayName("사다리의 높이가 1 미만이라면 예외를 발생시킨다")
    @Test
    void createLadderHeightExceptionTest() {
        int countOfPerson = 5;
        assertThatThrownBy(() -> new Ladder(new Height("0"), countOfPerson)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시작 지점으로 결과 지점을 얻는다")
    @Test
    void positionOfResultTest() {
        assertThat(ladder.positionOfResult(0)).isEqualTo(1);
    }

    @DisplayName("전체 지점의 결과 지점을 얻는다")
    @Test
    void resultOfAllResultTest() {
        assertThat(ladder.positionOfAllResult()).isEqualTo(List.of(1, 0));
    }
}
