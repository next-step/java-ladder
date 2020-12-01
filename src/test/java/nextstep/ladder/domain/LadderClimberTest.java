package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderClimberTest {
    @Test
    @DisplayName("사디라 타는 객체 생성")
    void createLadderClimber() {
        Players players = Players.from("a,b,c");
        Lines lines = Lines.fromHeight(players.getSize(), 3, (point) -> true);
        LadderClimber ladderClimber = new LadderClimber(players, lines);
    }
}
