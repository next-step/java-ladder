package nextstep.ladder.controller;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.OutPut;

public class LadderController {
    public static void main(String[] args) {
        int countOfLine = Input.InputCountOfLine();
        String participantsString = Input.InputParticipants();
        Participants participants = Participants.of(participantsString);
        Lines lines = Lines.ofRandom(participants.getParticipantsSize(), countOfLine);
        OutPut.viewParticipants(participants);
        OutPut.viewLadder(lines);
    }
}
