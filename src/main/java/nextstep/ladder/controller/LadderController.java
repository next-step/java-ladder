package nextstep.ladder.controller;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import nextstep.ladder.domain.*;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.OutPut;

public class LadderController {
    public static void main(String[] args) {
        String participantsString = Input.InputParticipants();
        int countOfLine = Input.InputCountOfLine();
        String compensationString = Input.InputCompensation();
        Compensations compensations = Compensations.of(compensationString);
        Participants participants = Participants.of(participantsString);
        Ladder ladder = Ladder.ofRandom(participants.getParticipantsSize(), countOfLine);
        OutPut.viewParticipants(participants);
        OutPut.viewLadder(ladder);
        OutPut.viewCompensation(compensations);
        Participant participantWantResult = Participant.of(Input.InputParticipantWantResult());
        PlayGame.playGame(participantWantResult, participants, compensations, ladder);
        OutPut.viewResult(participants,compensations,ladder,participantWantResult);
    }
}
