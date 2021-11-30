package view;

import domain.Floor;
import domain.Ladder;
import domain.Participants;

import java.util.List;

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
    public void showRequestForResultOfParticipant() {
        System.out.println("Who do you want to see the result?");
    }

    @Override
    public void showResultOfParticipant(String result) {
        System.out.println(result);
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
