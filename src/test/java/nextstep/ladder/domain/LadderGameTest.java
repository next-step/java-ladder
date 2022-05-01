package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.data.MapEntry.entry;

class LadderGameTest {

    private static final Ladder TWO_WIDTH_LADDER = Ladder.createLadder(2, 2);
    private static final Ladder THREE_WIDTH_LADDER = Ladder.createLadder(3, 2);
    private static final Participants THREE_PARTICIPANTS =
            Participants.createParticipants(List.of("a", "b", "c"));
    private static final Prizes TWO_PRIZES = Prizes.createPrizes(List.of(1, 2));


    @DisplayName("사다리 게임 생성시 참가자와 사다리 폭(width)이 다르면 예외")
    @Test
    void validation() {
        assertThatThrownBy(() -> new LadderGame(THREE_PARTICIPANTS, TWO_WIDTH_LADDER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void match() {
        Participants threeParticipants = Participants.createParticipants(List.of("a", "b", "c"));
        LadderGame ladderGame = new LadderGame(threeParticipants, THREE_WIDTH_LADDER);
        Prizes prizes = Prizes.createPrizes(List.of(1, 2, 3));

        Map<Participant, Prize> result = ladderGame.match(prizes)
                .getResult();

        assertThat(result).containsExactly(
                entry(new Participant("a"), new Prize(1)),
                entry(new Participant("b"), new Prize(2)),
                entry(new Participant("c"), new Prize(3)));
    }

    @DisplayName("Prize 크기가 Participants와 다르면 예외")
    @Test
    void GivenInvalidPrizeSize_match_ThrowsIllegalArgumentException() {
        LadderGame gameOfThreeParticipants = new LadderGame(THREE_PARTICIPANTS, THREE_WIDTH_LADDER);

        assertThatThrownBy(() -> gameOfThreeParticipants.match(TWO_PRIZES))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
