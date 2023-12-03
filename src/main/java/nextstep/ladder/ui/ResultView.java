package nextstep.ladder.ui;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.participant.Participant;
import nextstep.ladder.domain.participant.Participants;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ResultView {
    private LinePrinter printer;
    private final Lines lines;
    private final Participants participants;
    private final String[] results;

    public ResultView(LinePrinter printer, Lines lines, Participants participants, String[] results) {
        this.printer = printer;
        this.lines = lines;
        this.participants = participants;
        this.results = results;
    }

    public void showLadder() {
        System.out.println("");
        System.out.println("실행 결과");
        printParticipants();
        printLadder();
        printResults();
    }

    private void printParticipants() {
        participants.getParticipantList()
                .stream()
                .forEach(participant -> System.out.print(participant.getName() + " "));
        System.out.println("");
    }

    private void printLadder() {
        for (Line line : lines.getLineList()) {
            printLadderByOneLine(line);
            System.out.println("");
        }
    }

    private void printLadderByOneLine(Line line) {
        int rowLineNumber = participants.getParticipantsNumber() - 1;
        System.out.print("|");
        for (int index = 0; index < rowLineNumber; index++) {
            printer.printRefactoring(line.isTruePosition(index));
        }
    }

    private void printResults() {
        printResult(results[0]);
        IntStream.range(1, results.length)
                .forEach(index -> printResult(results[index]));
        System.out.println("");
    }

    private void printResult(String result) {
        if (result.equals("꽝")) {
            System.out.print(result + " ".repeat(results.length - 1));
            return;
        }
        System.out.print(result + " ".repeat(results.length - result.length()));
    }

    public void showParticipant(String name) {
        System.out.println("");
        if (name.equalsIgnoreCase("all")) {
            participants.getParticipantList()
                    .stream()
                    .forEach(participant -> printMyResult(participant));
            return;
        }
        Participant participant = participants.findByName(name);
        printMyResult(participant);
    }

    private void printMyResult(Participant participant) {
        System.out.println(participant.getName() + " : " + participant.getResult());
    }
}
