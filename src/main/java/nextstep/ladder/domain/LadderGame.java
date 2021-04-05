package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LadderGame {

    private final Participants participants;
    private final int ladderMaxHeight;

    private LadderGame(final int ladderMaxHeight, final String[] userName) {
        this.participants = Participants.of(Arrays.stream(userName)
                .map(Participant::of)
                .collect(Collectors.toList())
        );
        this.ladderMaxHeight = ladderMaxHeight;
    }

    public static LadderGame of(final int ladderMaxHeight, final String[] userName) {
        return new LadderGame(ladderMaxHeight, userName);
    }
}
