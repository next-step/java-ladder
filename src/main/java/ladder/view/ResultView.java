//package ladder.view;
//
//import ladder.domain.ladder.Ladder;
//import ladder.domain.ladder.LadderResultBoard;
//import ladder.domain.ladder.LadderResults;
//import ladder.domain.ladder.Line;
//import ladder.domain.participant.Participants;
//import ladder.domain.participant.Participant;
//
//import java.util.stream.IntStream;
//
//public final class ResultView {
//
//    private static final String EXECUTION_RESULT_MESSAGE = "\n실행결과";
//    private static final String NAME_FORMAT = "%6s";
//    private static final String LINE_FORMAT = "%6s";
//    private static final String CROSS_LINE = "-----|";
//    private static final String NORMAL_LINE = "     |";
//    private static final String RESULT_FORMAT = "%s : %s\n";
//
//    private static final int ZERO = 0;
//
//    private static class ResultViewHolder {
//        private static final ResultView instance = new ResultView();
//    }
//
//    private ResultView() {
//    }
//
//    public static final ResultView getInstance() {
//        return ResultViewHolder.instance;
//    }
//
//    public final void printLadderStatus(Participants participants, Ladder ladder, LadderResults results) {
//        printExecutionResult();
//        printparticipants(participants);
//        printLadder(ladder);
//        printLadderResult(results);
//    }
//
//    private final void printExecutionResult() {
//        System.out.println(EXECUTION_RESULT_MESSAGE);
//    }
//
//    private final void printLadder(Ladder ladder) {
//        ladder.stream().forEach(this::printLine);
//    }
//
//    private final void printparticipants(Participants participants) {
//        printParticipantsName(participants);
//    }
//
//    private final void printLadderResult(LadderResults results) {
//        StringBuilder stringBuilder = new StringBuilder();
//        IntStream.range(ZERO, results.size())
//                .forEach(index -> stringBuilder.append(String.format(NAME_FORMAT, results.get(index))));
//        System.out.println(stringBuilder);
//    }
//
//    private final void printLine(Line line) {
//        StringBuilder stringBuilder = new StringBuilder();
//        line.stream()
//                .map(point -> point.hasPoint())
//                .map(this::mapToLine)
//                .forEach(stringBuilder::append);
//        System.out.println(stringBuilder);
//    }
//
//    private final String mapToLine(Boolean lineResult) {
//        if (lineResult) {
//            return String.format(LINE_FORMAT, CROSS_LINE);
//        }
//        return String.format(LINE_FORMAT, NORMAL_LINE);
//    }
//
//    private final void printParticipantsName(Participants participants) {
//        StringBuilder stringBuilder = new StringBuilder();
//        participants.stream()
//                .map(Participant::name)
//                .map(name -> String.format(NAME_FORMAT, name))
//                .forEach(stringBuilder::append);
//        System.out.println(stringBuilder);
//    }
//
//    public final void printLadderGameResult(Participant participant, LadderResultBoard ladderResultBoard) {
//        StringBuilder stringBuilder = new StringBuilder();
//        String result = getFormatResult(ladderResultBoard, participant);
//        stringBuilder.append(result);
//        System.out.println(stringBuilder);
//    }
//
//    public final void printLadderGameResultAll(Participants participants, LadderResultBoard ladderResultBoard) {
//        printExecutionResult();
//        StringBuilder stringBuilder = new StringBuilder();
//        participants.stream().forEach(participant -> {
//                    String result = getFormatResult(ladderResultBoard, participant);
//                    stringBuilder.append(result);
//                }
//        );
//        System.out.println(stringBuilder);
//    }
//
//    private String getFormatResult(LadderResultBoard ladderResultBoard, Participant participant) {
//        return String.format(RESULT_FORMAT, participant.name(), ladderResultBoard.findResultByParticipant(participant));
//    }
//
//}