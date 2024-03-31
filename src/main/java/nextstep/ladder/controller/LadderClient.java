package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;

import static nextstep.ladder.view.ViewHelper.*;

public class LadderClient {
    public static void main(String[] args) {
        Participants participants = insertParticipant();
        Height height = insertHeight();
        System.out.println("실행결과");
        printHeader(participants);
        printLadder(new Lines(height.getSize(), participants.getSize()));
    }
}
