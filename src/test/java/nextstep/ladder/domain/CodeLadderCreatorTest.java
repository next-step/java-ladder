package nextstep.ladder.domain;

import nextstep.ladder.codeleesh.domain.Ladder;
import nextstep.ladder.codeleesh.domain.Line;
import nextstep.ladder.codeleesh.domain.Point;
import nextstep.ladder.engine.LadderCreator;
import nextstep.ladder.factory.LadderFactoryBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("사다리 생성 테스트")
class CodeLadderCreatorTest {

    @DisplayName("입력받은 높이와 사람수만큼 사다리를 생성한다.")
    @Test
    void create_ladder_input() {

        final LadderCreator ladderFactory = LadderFactoryBean.createLadderFactory();
        final Ladder ladder = ladderFactory.create(4, 5);
        final List<Line> lines = ladder.getLines();
        final List<Point> points = lines.get(0).getPoints();

        assertAll(
                () -> assertThat(lines).hasSize(5),
                () -> assertThat(points).hasSize(4)
        );
    }
}
