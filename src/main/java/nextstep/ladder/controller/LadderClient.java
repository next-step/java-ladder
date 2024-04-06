package nextstep.ladder.controller;

import nextstep.ladder.domain.*;

import static nextstep.ladder.view.ViewHelper.*;

public class LadderClient {
    public static void main(String[] args) {
        Participants participants = insertParticipant();
        ExecutionResults executionResults = insertExecutionResults();
        Height height = insertHeight();
        printHeader(participants);
        Lines lines = new Lines(height.getSize(), participants.getSize());
        printLadder(lines);
        Participants reOrderedParticipants = lines.switchOrder(participants);
        printBottom(executionResults);
        LadderMapping ladderMapping = new LadderMapping(reOrderedParticipants, executionResults);
        printResult(ladderMapping, participants);
    }
}
