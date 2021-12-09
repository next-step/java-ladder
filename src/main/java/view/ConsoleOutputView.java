package view;

import domain.*;

import java.util.List;
import java.util.stream.IntStream;

import static controller.LadderController.ALL_PARTICIPANTS;

public class ConsoleOutputView implements OutputView {
    private static final String BLANK_AFTER_NAME = " ";
    private static final String STAIR_EXIST = "-----";
    private static final String NO_STAIR = "     ";
    private static final String VERTICAL_BAR = "|";
    private static final String INITIAL_EMPTY_SPACE = "  ";

    @Override
    public void showRequestOfParticipants() {
        System.out.println("Enter The Names of Participants. (Names must be separated by comma(,)");
    }

    @Override
    public void showRequestOfLadderResult() {
        System.out.println("Enter The Result of Ladder. (Names must be separated by comma(,)");
    }

    @Override
    public void showRequestOfHeightOfLadder() {
        System.out.println("How Much Is The Height Of Ladder?");
    }

    @Override
    public void showMessageOfResult() {
        System.out.println("The Ladder Is As Following");
    }

    @Override
    public void showParticipants(Participants participants) {
        List<String> names = participants.getNamesOfParticipants();
        names.forEach(name -> System.out.printf("%5s" + BLANK_AFTER_NAME, name));
        System.out.println();
    }

    @Override
    public void showLadderGame(LadderGame ladderGame) {
        for (int i = 0; i < ladderGame.height(); i++) {
            String line = showLadderLine(ladderGame.nextLine(i));
            System.out.println(line);
        }
    }

    private String showLadderLine(List<Boolean> line) {
        return line.stream()
                .map(this::getLineExpression)
                .reduce(INITIAL_EMPTY_SPACE + VERTICAL_BAR, (accumulator, stair) ->
                        accumulator + stair + VERTICAL_BAR
                );
    }

    private String getLineExpression(boolean isExist) {
        return isExist ? STAIR_EXIST : NO_STAIR;
    }

    @Override
    public void showResults(List<String> results) {
        results.forEach(result -> System.out.printf("%5s" + BLANK_AFTER_NAME, result));
        System.out.println();
        System.out.println();
    }

    @Override
    public void showRequestForResultOfParticipant() {
        System.out.println("Who do you want to see the result?");
    }

    @Override
    public void showResultOfLadderGame(String participantName, LadderResult ladderResult, LadderGame ladderGame) {
        if (participantName.equals(ALL_PARTICIPANTS)) {
            showResultsOfAllParticipantsInLadderGame(ladderResult, ladderGame);
            return;
        }

        String result = ladderGame.result(participantName, ladderResult);
        showResultOfParticipantInLadderGame(result);
    }

    private void showResultsOfAllParticipantsInLadderGame(LadderResult ladderResult, LadderGame ladderGame) {
        List<String> participantNames = ladderGame.participantNames();
        List<String> results = ladderGame.allResults(ladderResult);

        IntStream.range(0, participantNames.size())
                .forEach(i -> showParticiantAndResult(participantNames.get(i), results.get(i)));
    }

    private void showParticiantAndResult(String participant, String result) {
        System.out.printf("%s : %s\n", participant, result);
    }

    private void showResultOfParticipantInLadderGame(String result) {
        System.out.println(result);
    }
}
