package nextstep.ladders.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final List<String> participants;
    private final Integer maxLadderHeight;

    public LadderGame(String participantsText, String maxLadderHeightText) {
        this.participants = parseParticipants(participantsText);
        this.maxLadderHeight = parseMaxLadderHeight(maxLadderHeightText);
    }

    private Integer parseMaxLadderHeight(final String maxLadderHeightText) {
        return Integer.parseInt(maxLadderHeightText);
    }

    private List<String> parseParticipants(final String participantsText) {
        return Arrays.stream(participantsText.split(","))
                .collect(Collectors.toList());
    }
}
