package ladder.view;

import ladder.domain.game.*;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * Created By mand2 on 2020-12-07.
 */
public class ResultView {

    public static final String RESULT_LADDER = "사다리 결과";
    public static final String RESULT_GOALS = "실행 결과";
    public static final String RESERVED_WORD_ALL = "all";

    public static final int NAME_SPACE = 5;
    public static final String BRIDGE_BLANK = " ";
    public static final String BRIDGE_CONNECTION = "-";
    public static final String BRIDGE_POLE = "|";
    public static final String RESULT_SEPARATOR = " : ";

    public static void printLadder(Names participants, Ladder ladder, Names goals) {
        System.out.println(System.lineSeparator() + RESULT_LADDER + System.lineSeparator());
        showNames(participants.getNames());
        showLadder(ladder.getLadder());
        showNames(goals.getNames());
    }

    public static void printGoals(LadderResult ladderResult, String inputName) {
        System.out.println(System.lineSeparator() + RESULT_GOALS);

        if (inputName.equals(RESERVED_WORD_ALL)) {
            showAllResults(ladderResult.getResultOfAll());
        }
        if (!inputName.equals(RESERVED_WORD_ALL)) {
            System.out.println(ladderResult.getResultOfOneParticipant(Name.from(inputName)));
        }
    }

    private static void showAllResults(Map<Name, Name> allResults) {
        allResults.entrySet().stream()
                .forEach(resultGoal -> {
                    System.out.print(resultGoal.getKey());
                    System.out.print(RESULT_SEPARATOR);
                    System.out.print(resultGoal.getValue());
                    System.out.println();
                });
    }

    private static void showNames(List<Name> names) {
        System.out.println(
                names.stream()
                .map(name -> String.format("%" + NAME_SPACE + "s", name))
                .collect(joining(BRIDGE_BLANK)));
    }

    private static void showLadder(List<Line> ladder) {
        ladder.stream()
                .forEach(line -> printLine(line.getLine()));
    }

    private static void printLine(List<Boolean> line) {
        line.forEach(hasConnected -> printBridge(hasConnected));
        System.out.println();
    }

    private static void printBridge(Boolean hasConnected) {
        System.out.print(printConnection(hasConnected));
        System.out.print(BRIDGE_POLE);
    }

    private static String printConnection(Boolean connected) {
        if (connected) {
            return repeat(BRIDGE_CONNECTION, NAME_SPACE);
        }
        return repeat(BRIDGE_BLANK, NAME_SPACE);
    }

    private static String repeat(String str, int times) {
        return IntStream.range(0, times).mapToObj(__ -> str).collect(joining());
    }


}
