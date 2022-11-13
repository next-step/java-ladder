package nextstep.ladder.domain;

import nextstep.ladder.codeleesh.domain.Line;
import nextstep.ladder.codeleesh.domain.CodeLineCreator;
import nextstep.ladder.codeleesh.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리의 한 라인 생성 테스트")
class CodeLineCreatorTest {

    @DisplayName("사다리 가로 한줄을 생성한다.")
    @Test
    void create_line() {

        final Line line = new CodeLineCreator().create(5);

        assertThat(line.getPoints()).hasSize(5);
    }

    @DisplayName("사다리 가로 한줄을 생성한다.")
    @Test
    void move_line() {

        final Line line =  new CodeLineCreator().create(5);
        for (Point point : line.getPoints()) {
            point.move();
        }
        assertThat(line.getPoints()).hasSize(5);
    }
}