package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderServiceTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void createLadderService() {
        final String inputNames = "hong,kim,jo";
        final int height = 5;

        LadderService ladderService = new LadderService(inputNames, height);

        Ladder ladder = ladderService.getLadder();

        List<User> users = ladder.getUsers();
        List<Line> lines = ladder.getLines();

        assertAll(
                () -> assertEquals(users.size(), 3),
                () -> assertEquals(lines.size(), height)
        );
    }
}