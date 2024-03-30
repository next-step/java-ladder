package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Participant;

import static nextstep.ladder.view.ViewHelper.*;

public class LadderClient {
    public static void main(String[] args) {
        Participant participant = insertParticipant();
        Height height = insertHeight();
        printResult(participant);
    }
}
