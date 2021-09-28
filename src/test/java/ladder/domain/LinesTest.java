package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

class LinesTest {

    private Lines lines;
    private Users users;

    @BeforeEach
    void setUp() {
        int countOfPerson = 3;
        User tom = new User("tom", 0);
        User jerry = new User("jerry", 2);
        User jane = new User("jane", 4);
        users = new Users(Arrays.asList(tom, jerry, jane));

        Line line = new Line(countOfPerson);
        line.addHeightLine(0);
        line.addWidthLine(1);
        line.addHeightLine(2);
        line.addHeightLine(4);

        Line line2 = new Line(countOfPerson);
        line2.addHeightLine(0);
        line2.addHeightLine(2);
        line2.addWidthLine(3);
        line2.addHeightLine(4);

        Line line3 = new Line(countOfPerson);
        line3.addHeightLine(0);
        line3.addHeightLine(2);
        line3.addHeightLine(4);

        Line line4 = new Line(countOfPerson);
        line4.addHeightLine(0);
        line4.addWidthLine(1);
        line4.addHeightLine(2);
        line4.addHeightLine(4);

        lines = new Lines(Arrays.asList(line, line2, line3, line4));

        for (Line route : lines) {
            List<User> userList = new ArrayList<>();
            for (User user : users) {
                User newUser = new User(user.name(), route.findRoute(user.position()));
                userList.add(newUser);
            }
            users = new Users(userList);
        }
    }

    @Test
    @DisplayName("게임 결과 테스트")
    public void lineGameResultTest() {
        assertAll(
                () -> Assertions.assertThat(users.findByName("tom").position()).isEqualTo(4),
                () -> Assertions.assertThat(users.findByName("jerry").position()).isEqualTo(2),
                () -> Assertions.assertThat(users.findByName("jane").position()).isEqualTo(0)
        );
    }
}
