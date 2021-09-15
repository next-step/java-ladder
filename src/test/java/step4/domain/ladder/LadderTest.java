package step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.user.User;
import step4.domain.user.Users;

class LadderTest {

    @Test
    @DisplayName("사다리 높이와 User를 받아 사다리를 만들 수 있다.")
    void createLadderTest() {

        // given
        LadderHeight height = LadderHeight.of(2);
        LadderLine line = LadderLine.of(Arrays.asList(Point.from(0, Direction.from(false, true)),
            Point.from(1, Direction.from(true, false)),
            Point.from(2, Direction.from(false, true)),
            Point.from(3, Direction.from(true, false))));
        List<LadderLine> lines = Arrays.asList(line, line);
        Ladder expected = Ladder.of(lines);
        Users users = Users.of("pobi,honux,crong,jk");

        // when
        Ladder result = Ladder.createLadder(height, users, () -> true);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리 게임의 결과를 반환할 수 있다.")
    void calculateLadderResultTest() {

        // given
        Users users = Users.of("pobi,honux,crong,jk");
        LadderEndPoints endPoints = LadderEndPoints.from("꽝,5000,꽝,3000", users);
        LadderHeight height = LadderHeight.of(5);
        Ladder ladder = Ladder.createLadder(height, users, () -> true);

        Map<User, String> map = new HashMap<>();
        map.put(User.of("pobi"), "5000");
        map.put(User.of("honux"), "꽝");
        map.put(User.of("crong"), "3000");
        map.put(User.of("jk"), "꽝");
        LadderResult expected = LadderResult.of(map);

        // when
        LadderResult result = ladder.createResult(users, endPoints);

        // then
        assertThat(result).isEqualTo(expected);
    }

}