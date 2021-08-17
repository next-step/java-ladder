package nextstep.ladders.controller;

import nextstep.ladders.domain.Ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    public Ladder start(final String participantsText, final String maxLadderHeightText) {
        List<String> names = parseParticipants(participantsText);
        int height = parseMaxLadderHeight(maxLadderHeightText);
        return new Ladder(names, height);
    }

    private Integer parseMaxLadderHeight(final String maxLadderHeightText) {
        return Integer.parseInt(maxLadderHeightText);
    }

    private List<String> parseParticipants(final String participantsText) {
        return Arrays.stream(participantsText.split(","))
                .collect(Collectors.toList());
    }
}
