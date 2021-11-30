package view;

import domain.Ladder;
import domain.Participants;

import java.util.List;

public interface OutputView {
    void showRequestOfParticipants();
    void showRequestOfLadderResult();
    void showRequestOfHeightOfLadder();
    void showMessageOfResult();
    void showParticipants(Participants participants);
    void showLadder(Ladder ladder);
    void showResults(String[] results);
    void showRequestForResultOfParticipant();
    void showResultOfParticipant(String result);
    void showResultsOfAllParticipants(Participants participants, Ladder ladder);
}
