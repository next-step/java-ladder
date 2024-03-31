package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.ParticipantPosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    public static final LadderGame LADDER_GAME = LadderGame.of(List.of("pobi", "honux", "crong", "ny"),
            List.of(
                    Line.of(true, false, true),
                    Line.of(false, true, false),
                    Line.of(true, false, false),
                    Line.of(false, true, false),
                    Line.of(true, false, true)
            )
    );

    @Test
    @DisplayName("[성공] 사다리 게임을 생성한다.")
    void 사다리_게임_생성() {
        assertThat(LADDER_GAME.getParticipantsSize()).isEqualTo(4);
        assertThat(LADDER_GAME.getLadderHeight()).isEqualTo(5);
    }

    @Test
    @DisplayName("[성공] 사다리 게임을 실행한다.")
    void 사다리_게임_실행() {
        assertThat(LADDER_GAME.execute("pobi")).containsOnly(ParticipantPosition.of("pobi", 0));
    }

}
