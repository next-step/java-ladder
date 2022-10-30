package laddergame.view;

import laddergame.domain.PersonName;
import laddergame.domain.Rewards;
import laddergame.domain.service.LadderGame;
import laddergame.dto.LadderRecord;
import laddergame.dto.LineRecord;
import laddergame.dto.RewordRecords;

import java.util.List;


public class OutputView {

    private static final String TAB = " ";
    private static final int WIDTH = 5;
    private static final String COLUMN = "|";
    private static final String LINE = "-";

    private OutputView() {
    }

    public static void printLadder(LadderGame ladderGame) {
        System.out.println("실행결과");
        printPersonNames(ladderGame.getPersonNames());
        printLines(ladderGame.getLadderRecord());
        printRewards(ladderGame.getRewards());
    }

    private static void printLines(LadderRecord ladderRecord) {
        ladderRecord.getRecord().forEach(line -> System.out.println(printLine(line)));
    }

    private static String printLine(LineRecord lineRecord) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TAB.repeat(WIDTH)).append(COLUMN);

        lineRecord.getRecord().forEach(l -> stringBuilder.append(getRung(l).repeat(WIDTH)).append(COLUMN));

        return stringBuilder.toString();
    }

    private static String getRung(boolean point) {
        if (point) {
            return LINE;
        }
        return TAB;
    }

    private static void printPersonNames(List<PersonName> personNames) {
        StringBuilder stringBuilder = new StringBuilder();
        personNames.forEach(n -> stringBuilder.append(lpad(n.toString())));
        System.out.println(stringBuilder);
    }

    private static void printRewards(Rewards rewards) {
        StringBuilder stringBuilder = new StringBuilder();
        rewards.getRewards().forEach(n -> stringBuilder.append(lpad(n.toString())));
        System.out.println(stringBuilder);
    }

    private static String lpad(String name) {
        return TAB.repeat(WIDTH).substring(name.length()) + name + TAB;
    }

    public static void printResult(RewordRecords result) {
        System.out.println("실행 결과");
        result.getRecords().forEach(record -> System.out.println(record.getPlayerName() + " : " + record.getReword()));

    }
}
