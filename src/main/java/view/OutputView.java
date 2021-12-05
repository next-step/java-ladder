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
    void showResults(String[] results);
    void showRequestForResultOfParticipant();
    void showResultOfLadderGame(String participant, Participants participants, Ladder ladder);
    void showResultOfParticipantInLadderGame(String result);
    void showResultsOfAllParticipantsInLadderGame(Participants participants, Ladder ladder);
}
