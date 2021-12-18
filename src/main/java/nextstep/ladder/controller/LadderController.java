package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.OutPut;

import java.util.Map;

public class LadderController {
    public static void main(String[] args) {
        String participantsString = Input.InputParticipants();
        int countOfLine = Input.InputCountOfLine();

        String compensationString = Input.InputCompensation();
        Participants participants = Participants.of(participantsString);

        Compensations compensations = Compensations.of(compensationString, participants.getParticipantsSize());
        Ladder ladder = Ladder.ofRandom(participants.getParticipantsSize(), countOfLine);

        OutPut.viewParticipants(participants);
        OutPut.viewLadder(ladder);
        OutPut.viewCompensation(compensations);

        Participant participantWantResult = Participant.of(Input.InputParticipantWantResult(), 0);
        PlayGame playGame = PlayGame.of(participants, compensations);
        Map<String, String> result = playGame.playGame(participantWantResult, ladder);

        OutPut.viewResult(participants, result);
    }
}
