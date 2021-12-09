package view;

import domain.LadderGame;
import domain.LadderResult;
import domain.Participants;

import java.util.List;

public interface OutputView {
    void showRequestOfParticipants();
    void showRequestOfLadderResult();
    void showRequestOfHeightOfLadder();
    void showMessageOfResult();
    void showParticipants(Participants participants);
    void showLadderGame(LadderGame ladder);
    void showResults(List<String> results);
    void showRequestForResultOfParticipant();
    void showResultOfLadderGame(String participantName, LadderResult ladderResult, LadderGame ladderGame);
}
