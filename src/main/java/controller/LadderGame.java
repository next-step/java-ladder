package controller;

import domain.*;
import view.ConsoleInputView;
import view.ConsoleOutputView;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.RandomGenerator.produceRandomFlags;
import static util.StringUtils.separateStringWithComma;

public class LadderGame {
    private static final int DECREMENT_FOR_STAIRS_PER_FLOOR = 1;
    private static final int START_POINT_FOR_CONSTRUCTING_FLOORS = 0;
    private static final String ALL_PARTICIPANTS = "all";

    private LadderGame() {

    }

    public static void runGame() {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();

        outputView.showRequestOfParticipants();
        String rawInputNames = inputView.getParticipantsNames();
        String[] participantNames = separateStringWithComma(rawInputNames);
        Participants participants = new Participants(constructParticipants(participantNames));

        outputView.showRequestOfLadderResult();
        String rawInputLadderResult = inputView.getLadderResult();
        String[] ladderResult = separateStringWithComma(rawInputLadderResult);

        outputView.showRequestOfHeightOfLadder();
        int heightOfLadder = inputView.getHeightOfLadder();
        Floors floors = new Floors(constructFloors(heightOfLadder, participants.size()));
        Ladder ladder = new Ladder(floors, new LadderResult(Arrays.stream(ladderResult).collect(Collectors.toList())));

        outputView.showMessageOfResult();
        outputView.showParticipants(participants);
        outputView.showLadder(ladder);
        outputView.showResults(ladderResult);

        while (true) {
            outputView.showRequestForResultOfParticipant();
            String participant = inputView.getParticipantForResult();
            if (participant.equals(ALL_PARTICIPANTS)) {
                outputView.showResultsOfAllParticipants(participants, ladder);
                continue;
            }
            String result = ladder.finalResult(participants.initialPosition(new Participant(participant)));
            outputView.showResultOfParticipant(result);
        }
    }

    public static List<Participant> constructParticipants(String[] names) {
        List<Participant> participants = new ArrayList<>();

        Arrays.stream(names)
                .forEach(name -> participants.add(new Participant(name)));

        return participants;
    }

    public static List<Floor> constructFloors(int heightOfLadder, int participantSize) {
        List<Floor> floors = new ArrayList<>();
        IntStream.range(START_POINT_FOR_CONSTRUCTING_FLOORS, heightOfLadder)
                .forEach(i -> {
                    floors.add(constructFloor(participantSize));
                });

        return floors;
    }

    private static Floor constructFloor(int participantSize) {
        int numberOfStairsPerFloor = participantSize - DECREMENT_FOR_STAIRS_PER_FLOOR;
        List<Boolean> randomFlags = produceRandomFlags(numberOfStairsPerFloor);

        return new Floor(randomFlags);
    }
}
