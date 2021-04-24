//package ladder;
//
//import ladder.domain.ladder.*;
//import ladder.domain.participant.Participant;
//import ladder.domain.participant.Participants;
//import ladder.exception.NoSuchPersonException;
//import ladder.exception.ParticipantsAndResultsSizeMissMatchException;
//import ladder.strategy.RandomLineGenerateStrategy;
//import ladder.view.InputView;
//import ladder.view.ResultView;
//
//import java.util.List;
//
//public final class LadderGame {
//
//    private static final String ALL_COMMAND = "all";
//
//    private static final InputView INPUT_VIEW;
//    private static final ResultView RESULT_VIEW;
//
//    static {
//        INPUT_VIEW = InputView.getInstance();
//        RESULT_VIEW = ResultView.getInstance();
//    }
//
//    public static final void main(String[] args) {
//        Participants participants = getInputParticipants();
//        LadderResults results = getInputLadderResults(participants);
//        LadderHeight height = getInputLadderHeight();
//
//        Ladder ladder = Ladder.from(participants, height, RandomLineGenerateStrategy.getInstance());
//
//        RESULT_VIEW.printLadderStatus(participants, ladder, results);
//
//        LadderResultBoard ladderResultBoard = ladder.run(participants, results);
//        printLadderResultBoard(participants, ladderResultBoard);
//    }
//
//    private static final Participants getInputParticipants() {
//        try {
//            return Participants.of(INPUT_VIEW.inputParticipantsByClient());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return getInputParticipants();
//        }
//    }
//
//    private static final LadderResults getInputLadderResults(Participants participants) {
//        try {
//            String[] ladderResults = INPUT_VIEW.inputLadderResultsByClient();
//            validateSize(participants, ladderResults);
//            return LadderResults.of(ladderResults);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return getInputLadderResults(participants);
//        }
//    }
//
//    private static final void validateSize(Participants participants, String[] ladderResults) {
//        if (ladderResults.length != participants.countOfParticipants()) {
//            throw new ParticipantsAndResultsSizeMissMatchException();
//        }
//    }
//
//
//    private static final LadderHeight getInputLadderHeight() {
//        try {
//            return LadderHeight.valueOf(INPUT_VIEW.inputLadderHeightByClient());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return getInputLadderHeight();
//        }
//    }
//
//    private static final void printLadderResultBoard(Participants participants, LadderResultBoard ladderResultBoard) {
//        String command = getCommand(participants);
//        if (isNotCommandAll(command)) {
//            RESULT_VIEW.printLadderGameResult(Participant.of(command), ladderResultBoard);
//            printLadderResultBoard(participants, ladderResultBoard);
//            return;
//        }
//        RESULT_VIEW.printLadderGameResultAll(participants, ladderResultBoard);
//    }
//
//    private static final boolean isNotCommandAll(String command) {
//        return (!command.equals(ALL_COMMAND));
//    }
//
//    private static final String getCommand(Participants participants) {
//        try {
//            List<String> names = participants.values();
//            String command = INPUT_VIEW.inputResultPersonByClient();
//            validateAvailableName(names, command);
//            return command;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return getCommand(participants);
//        }
//    }
//
//    private static final String validateAvailableName(List<String> names, String command) {
//        return names.stream()
//                .filter(name -> name.equals(command))
//                .findFirst()
//                .orElseThrow(() -> new NoSuchPersonException());
//    }
//}