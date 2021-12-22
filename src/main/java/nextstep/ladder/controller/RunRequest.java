package nextstep.ladder.controller;

import java.util.List;

public class RunRequest {
    private final List<String> participantNames;
    private final int heightOfLadder;

    private RunRequest(List<String> participantNames, int heightOfLadder) {
        this.participantNames = participantNames;
        this.heightOfLadder = heightOfLadder;
    }

    public static RunRequest of(List<String> participantNames, int heightOfLadder) {
        return new RunRequest(participantNames, heightOfLadder);
    }
}
