package view;

import domain.Floor;
import domain.Ladder;
import domain.Participant;
import domain.Participants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static controller.LadderGame.ALL_PARTICIPANTS;

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
    public void showLadder(Ladder ladder) {
        List<Floor> floors = ladder.getFloors();
        floors.forEach(this::showFloor);
    }

    @Override
    public void showResults(String[] results) {
        Arrays.stream(results).forEach(result -> System.out.printf("%5s" + BLANK_AFTER_NAME, result));
        System.out.println();
        System.out.println();
    }

    @Override
    public void showRequestForResultOfParticipant() {
        System.out.println("Who do you want to see the result?");
    }

    @Override
    public void showResultOfLadderGame(String participant, Participants participants, Ladder ladder) {
        if (participant.equals(ALL_PARTICIPANTS)) {
            showResultsOfAllParticipantsInLadderGame(participants, ladder);
            return;
        }

        String result = ladder.finalResult(participants.initialPosition(new Participant(participant)));
        showResultOfParticipantInLadderGame(result);
    }

    @Override
    public void showResultOfParticipantInLadderGame(String result) {
        System.out.println(result);
    }

    @Override
    public void showResultsOfAllParticipantsInLadderGame(Participants participants, Ladder ladder) {
        List<String> participantNames = participants.getNamesOfParticipants();
        List<String> results = ladder.finalResultsOfAll(participants.size());

        IntStream.range(0, participants.size())
                .forEach(i -> showParticiantAndResult(participantNames.get(i), results.get(i)));
    }

    private void showParticiantAndResult(String participant, String result) {
        System.out.printf("%s : %s\n", participant, result);
    }

    private void showFloor(Floor floor) {
        String floorState = floor.getStates().stream()
                .map(this::getStairExpression)
                .reduce(INITIAL_EMPTY_SPACE + VERTICAL_BAR, (accumulator, stair) ->
                    accumulator + stair + VERTICAL_BAR
                );
        System.out.println(floorState);
    }

    private String getStairExpression(boolean isExist) {
        return isExist ? STAIR_EXIST : NO_STAIR;
    }
}
