package view;

import domain.Ladder;
import domain.Participants;

public interface OutputView {
    void showRequestOfParticipants();
    void showRequestOfLadderResult();
    void showRequestOfHeightOfLadder();
    void showMessageOfResult();
    void showParticipants(Participants participants);
    void showLadder(Ladder ladder);
    void showRequestForResultOfParticipant();
    void showResultOfParticipant(String result);
}
