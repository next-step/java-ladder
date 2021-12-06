package view;

import domain.Ladder;
import domain.LadderResult;
import domain.Participants;

import java.util.List;

public interface OutputView {
    void showRequestOfParticipants();
    void showRequestOfLadderResult();
    void showRequestOfHeightOfLadder();
    void showMessageOfResult();
    void showParticipants(Participants participants);
    void showLadder(Ladder ladder);
    void showResults(List<String> results);
    void showRequestForResultOfParticipant();
    void showResultOfLadderGame(String participant, Participants participants, LadderResult ladderResult, Ladder ladder);
    void showResultOfParticipantInLadderGame(String result);
    void showResultsOfAllParticipantsInLadderGame(Participants participants, LadderResult ladderResult, Ladder ladder);
}
