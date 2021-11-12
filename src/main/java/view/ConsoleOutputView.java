package view;

import domain.Floor;
import domain.Floors;
import domain.Ladder;
import domain.Participants;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    private final String BLANK_AFTER_NAME = " ";
    private final String STAIR_EXIST = "-----";
    private final String NO_STAIR = "     ";
    private final String VERTICAL_BAR = "|";
    private final String INITIAL_EMPTY_SPACE = "  ";

    @Override
    public void showRequestOfParticipants() {
        System.out.println("Enter The Names of Participants: (Names must be separated by comma(,)");
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
    public void showResult(Ladder ladder) {
        Floors floors = ladder.getFloors();
        floors.stream().forEach(this::showFloor);
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
