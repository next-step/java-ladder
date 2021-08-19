package nextstep.ladders.controller;

import nextstep.ladders.domain.Ladder;
import nextstep.ladders.domain.Participants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    public static final String REGEX_COMMA = ",";

    public Participants register(final String participantsText) {
        List<String> names = parseParticipants(participantsText);
        return new Participants(names);
    }

    public Ladder start(final int countOfPerson, final String maxLadderHeightText) {
        int height = parseMaxLadderHeight(maxLadderHeightText);
        return new Ladder(countOfPerson, height);
    }

    private Integer parseMaxLadderHeight(final String maxLadderHeightText) {
        return Integer.parseInt(maxLadderHeightText);
    }

    private List<String> parseParticipants(final String participantsText) {
        return Arrays.stream(participantsText.split(REGEX_COMMA))
                .collect(Collectors.toList());
    }
}
