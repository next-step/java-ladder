package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void createLadder() {
        Users users = new Users(List.of(UserTest.USER_TEST1, UserTest.USER_TEST2));
        Lines lines = new Lines(List.of(LineTest.LINE_TEST1, LineTest.LINE_TEST2));

        Ladder ladder = new Ladder(users, lines);

        assertAll(
                () -> assertEquals(ladder.getUsers(), users.getUsers()),
                () -> assertEquals(ladder.getLines(), lines.getLines())
        );
    }
}