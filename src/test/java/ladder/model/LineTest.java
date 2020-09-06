package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LineTest {

    @Test
    @DisplayName("Line 생성 테스트")
    public void createLine() {
        // given
        LadderGenerateStrategy condition = () -> true;
        List<Boolean> expectedSteps = Arrays.asList(true, false, true, false);

        // when
        Line line = new Line(4, condition);

        // then
        assertThat(line.getSteps()).isEqualTo(expectedSteps);
    }

    @Test
    @DisplayName("사다리 타기 테스트 : 다리가 있는 경우")
    public void processLine_has_step() {
        // given
        LadderGenerateStrategy condition = () -> true;
        Line line = new Line(1, condition);

        User user1 = new User("toto");
        User user2 = new User("kim");
        Users users = new Users(Arrays.asList(user1, user2));

        List<User> expected = Arrays.asList(user2, user1);

        // when
        line.processLine(users);

        // then
        assertThat(users.getUsers()).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 타기 테스트 : 다리가 없는 경우")
    public void processLine_dose_not_have_step() {
        // given
        LadderGenerateStrategy condition = () -> false;
        Line line = new Line(1, condition);

        User user1 = new User("jk");
        User user2 = new User("kim");
        User user3 = new User("vivi");
        Users users = new Users(Arrays.asList(user1, user2, user3));

        List<User> expected = Arrays.asList(user1, user2, user3);

        // when
        line.processLine(users);

        // then
        assertThat(users.getUsers()).isEqualTo(expected);
    }

}
