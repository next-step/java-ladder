package view;

import domain.Ladder;
import domain.Participants;

public interface OutputView {
    void showRequestOfParticipants();
    void showRequestOfHeightOfLadder();
    void showMessageOfResult();
    void showParticipants(Participants participants);
    void showResult(Ladder ladder);
}
