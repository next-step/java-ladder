package step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step4.domain.user.Users;

class LadderLineTest {

    private static Users users;

    @BeforeAll
    static void beforeAll() {
        users = Users.of("pobi,honux,crong,jk");
    }

    @Nested
    @DisplayName("사다리 사람수에 맞게 Point를 생성할 수 있다.")
    class createLadderLineTest {

        @Test
        @DisplayName("[startegy 항상 true]")
        void strategyTrueTest() {

            // given
            LadderLine expected = LadderLine.of(Arrays.asList(Point.from(0, Direction.from(false, true)),
                Point.from(1, Direction.from(true, false)),
                Point.from(2, Direction.from(false, true)),
                Point.from(3, Direction.from(true, false))));

            // when
            LadderLine result = LadderLine.createLine(users, () -> true);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("[startegy 항상 false]")
        void strategyFalseTest() {

            // given
            LadderLine expected = LadderLine.of(Arrays.asList(Point.from(0, Direction.from(false, false)),
                Point.from(1, Direction.from(false, false)),
                Point.from(2, Direction.from(false, false)),
                Point.from(3, Direction.from(false, false))));

            // when
            LadderLine result = LadderLine.createLine(users, () -> false);

            // then
            assertThat(result).isEqualTo(expected);
        }

    }
}