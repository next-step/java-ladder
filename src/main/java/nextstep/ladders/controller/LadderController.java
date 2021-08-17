package nextstep.ladders.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {


    private Integer parseMaxLadderHeight(final String maxLadderHeightText) {
        return Integer.parseInt(maxLadderHeightText);
    }

    private List<String> parseParticipants(final String participantsText) {
        return Arrays.stream(participantsText.split(","))
                .collect(Collectors.toList());
    }
}
