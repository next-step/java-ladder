package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @DisplayName("사다리 라인 사이즈테스트")
    @Test
    void makeLines_Test() {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("sia"),
                new User("kim"),
                new User("gcc"),
                new User("zorba")
        ));

        int height = 5;
        Ladder ladder = new Ladder();
        ladder.makeLines(users, height);

        assertThat(ladder.getLines().size()).isEqualTo(5);
    }
}
