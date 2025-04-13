package nextstep.ladder.domain.line;

import nextstep.ladder.domain.edge.LadderUser;
import nextstep.ladder.domain.edge.LadderUsers;
import nextstep.ladder.domain.edge.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LinesTest {

    @DisplayName("Lines 인스턴스 만들기")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Lines(new Dimension(4), new Dimension(3), new LineFactory(new PointFactory())));
    }

    @DisplayName("유저들을 움직이기 - 2 height")
    @Test
    public void testMoveUsers_2Height() {
        Random random = new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };

        LineFactory lineFactory = new LineFactory(new PointFactory(random));
        Lines lines = new Lines(new Dimension(4), new Dimension(2), lineFactory);
        LadderUsers ladderUsers = new LadderUsers(List.of(
            new LadderUser("pobi", new Position(0)),
            new LadderUser("honux", new Position(1)),
            new LadderUser("crong", new Position(2)),
            new LadderUser("jk", new Position(3))
        ));
        assertThat(lines.moveUsers(ladderUsers))
            .isEqualTo(new LadderUsers(List.of(
                new LadderUser("pobi", new Position(0)),
                new LadderUser("honux", new Position(1)),
                new LadderUser("crong", new Position(2)),
                new LadderUser("jk", new Position(3))
            )));
    }

    @DisplayName("유저들을 움직이기 - 3 height")
    @Test
    public void testMoveUsers_3Height() {
        Random random = new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };

        LineFactory lineFactory = new LineFactory(new PointFactory(random));
        Lines lines = new Lines(new Dimension(4), new Dimension(3), lineFactory);
        LadderUsers ladderUsers = new LadderUsers(List.of(
            new LadderUser("pobi", new Position(0)),
            new LadderUser("honux", new Position(1)),
            new LadderUser("crong", new Position(2)),
            new LadderUser("jk", new Position(3))
        ));
        assertThat(lines.moveUsers(ladderUsers))
            .isEqualTo(new LadderUsers(List.of(
                new LadderUser("pobi", new Position(1)),
                new LadderUser("honux", new Position(0)),
                new LadderUser("crong", new Position(3)),
                new LadderUser("jk", new Position(2))
            )));
    }
}
