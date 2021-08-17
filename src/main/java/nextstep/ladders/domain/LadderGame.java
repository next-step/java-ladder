package nextstep.ladders.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final Participants participants;
    private final Height maxHeight;

    public LadderGame(final String namesText, String maxLadderHeightText) {
        this.participants = new Participants(parseParticipants(namesText));
        this.maxHeight = Height.valueOf(parseMaxLadderHeight(maxLadderHeightText));
    }

    private Integer parseMaxLadderHeight(final String maxLadderHeightText) {
        return Integer.parseInt(maxLadderHeightText);
    }

    private List<String> parseParticipants(final String participantsText) {
        return Arrays.stream(participantsText.split(","))
                .collect(Collectors.toList());
    }
}
