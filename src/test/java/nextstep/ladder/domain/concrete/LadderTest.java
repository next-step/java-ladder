package nextstep.ladder.domain.concrete;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.concrete.Ladder;
import nextstep.ladder.domain.concrete.Line;
import nextstep.ladder.fixtures.BraceFixtures;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Ladder 는 아무런 라인이 주어지지 않으면 예외를 던진다.")
    void newObject_NullAndEmpty_throwsException(List<Line> lines) {
        assertThatThrownBy(
                () -> new Ladder(lines)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move_success() {
        Line firstLine = new Line(List.of(
                BraceFixtures.right(), BraceFixtures.left(), BraceFixtures.none(), BraceFixtures.none()
        ));
        assertThat(firstLine.move(new Position(0))).isEqualTo(new Position(1));
        assertThat(firstLine.move(new Position(1))).isEqualTo(new Position(0));
        assertThat(firstLine.move(new Position(2))).isEqualTo(new Position(2));
        assertThat(firstLine.move(new Position(3))).isEqualTo(new Position(3));
    }
}
