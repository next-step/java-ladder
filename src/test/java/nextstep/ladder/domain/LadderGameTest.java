package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LadderGameTest {

    private static final Participants THREE_PARTICIPANTS =
            Participants.createParticipants(List.of("a", "b", "c"));
    private static final Ladder TWO_WIDTH_LADDER = Ladder.createLadder(2, 2);
    private static final Ladder THREE_WIDTH_LADDER = Ladder.createLadder(3, 2);
    private static final Prizes TWO_PRIZES = Prizes.createPrizes(List.of("1", "2"));


    @DisplayName("사다리 게임 생성시 참가자 수와 사다리 폭(width)이 다르면 예외")
    @Test
    void validation() {
        assertThatThrownBy(() -> new LadderGame(THREE_PARTICIPANTS, TWO_WIDTH_LADDER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 게임 실행시 참가자 수와 상금의 크기가 다르면 예외")
    @Test
    void GivenInvalidSizedPrize_play_ThrowsIllegalArgumentException() {
        LadderGame ladderGame = new LadderGame(THREE_PARTICIPANTS, THREE_WIDTH_LADDER);

        assertThatThrownBy(() -> ladderGame.play(TWO_PRIZES))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void play() {
        Participants participants = Participants.createParticipants(List.of("pobi", "honux", "crong", "jk"));
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(List.of(true, false, true, false)));
        lines.add(new Line(List.of(false, true, false, false)));
        lines.add(new Line(List.of(true, false, false, false)));
        lines.add(new Line(List.of(false, true, false, false)));
        lines.add(new Line(List.of(true, false, true, false)));
        Ladder ladder = Ladder.createLadder(lines, participants.size());
        LadderGame ladderGame = new LadderGame(participants, ladder);

        LadderGameResult result = ladderGame.play(Prizes.createPrizes(List.of("꽝", "5000", "꽝", "3000")));

        assertThat(result.findPrizeByName("pobi")).isEqualTo("꽝");
        assertThat(result.findPrizeByName("honux")).isEqualTo("3000");
        assertThat(result.findPrizeByName("crong")).isEqualTo("꽝");
        assertThat(result.findPrizeByName("jk")).isEqualTo("5000");
    }
}
