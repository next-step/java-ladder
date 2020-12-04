package nextstep.ladder.domain.alternative;

import nextstep.ladder.domain.TestingBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 요구사항
 * <p>
 * * 넓이(플레이어 수)를 입력받는다.
 * * 플레이어 수 만큼 Point 들을 생성한다
 * * Point 간 이동을 대리하는 move 메시지를 제공한다.
 */
public class LadderLineTest {
    @Test
    void create() {
        assertThat(LadderLine.of(3).sizeOfPoints()).isEqualTo(3);
    }

    @Test
    void createWithPoint() {
        assertThat(LadderLine.of(3, new TestingBooleanGenerator(true, false)))
                .isEqualTo(new LadderLine(buildPoints(true, false)));
    }

    @DisplayName("`|-----|     |` 에서 index 1 에서 이동하면 index 0 을 리턴한다")
    @Test
    void move() {
        assertThat(LadderLine.of(3, new TestingBooleanGenerator(true, false)).move(1))
                .isEqualTo(0);
    }

    private List<Point> buildPoints(Boolean... booleans) {
        return new PointListBuilder(booleans).build();
    }

}
