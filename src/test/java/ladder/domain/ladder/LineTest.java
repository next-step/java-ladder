package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import ladder.domain.user.Users;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LineTest {

    private static Users users;

    @BeforeAll
    static void beforeAll() {
        users = Users.of("pobi,honux,crong,jk");
    }


    @Nested
    @DisplayName("한 point가 true라면 항상 다음 point는 false여야 한다.")
    class truePointNextFalseTest {

        // given
        private int userCount = 4;

        @Test
        @DisplayName("[항상 true를 생성할 경우]")
        void tureGenerateStrategy() {

            // given
            Line expected = new Line(Arrays.asList(new Point(0, false, true),
                new Point(1, true, false),
                new Point(2, false, true),
                new Point(3, true, false)));

            // when
            Line result = Line.generateRandomLine(users, () -> true);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("[항상 false를 생성할 때]")
        void falseGenerateStrategy() {

            // given
            Line expected = new Line(Arrays.asList(new Point(0,  false, false),
                new Point(1, false, false),
                new Point(2, false, false),
                new Point(3, false, false)));

            // when
            Line result = Line.generateRandomLine(users, () -> false);

            // then
            assertThat(result).isEqualTo(expected);
        }

    }

    @Test
    @DisplayName("오른쪽 point가 연결되어 있다면 오른쪽 point로 이동할 수 있다.")
    void moveRightSuccessTest() {

        // given
        int index = 0;
        Line line = Line.generateRandomLine(users, () -> true);

        // when
        int result = line.move(index);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽 point가 있고, 연결되어있다면 왼쪽 point로 이동할 수 있다.")
    void moveLeftSuccessTest() {

        // given
        int index = 1;
        Line line = Line.generateRandomLine(users, () -> true);

        // when
        int result = line.move(index);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("왼쪽 오른쪽 둘다 이동 불가능 상태면 현재 point를 반환해야한다.")
    void moveFailTest() {

        // given
        int index = 1;
        Line line = Line.generateRandomLine(users, () -> false);

        // when
        int result = line.move(index);

        // then
        assertThat(result).isEqualTo(index);
    }

}