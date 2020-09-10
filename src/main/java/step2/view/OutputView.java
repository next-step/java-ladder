package step2.view;

import step2.model.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INITIAL_LINE = "    |";
    private static final String RUNG_CONDITION_TRUE = "-----|";
    private static final String RUNG_CONDITION_FALSE = "     |";
    public static final String ALL_MEMBERS = "all";
    private static final Scanner scanner = new Scanner(System.in);

    public static void printAll(Participants participants, Ladder ladderGame, PrizeLocation prizeLocation) {
        Banner();
        printNameList(participants);
        printLadder(ladderGame);
        printPrizeList(prizeLocation);
        printResult(participants, prizeLocation);
    }

    private static void printResult(Participants participants, PrizeLocation prizeLocation) {
        String name = "";
        while (!name.toLowerCase().equals(ALL_MEMBERS)) {
            System.out.println("결과를 보고 싶은 사람은?");
            name = scanner.nextLine();
            getThePrizeFromName(participants, prizeLocation, name);
        }
    }

    private static void getThePrizeFromName(Participants participants, PrizeLocation prizeLocation, String name) {
        if (name.toLowerCase().equals(ALL_MEMBERS)) {
            getTheAllPrizeList(participants, prizeLocation);
        }
        if (!name.toLowerCase().equals(ALL_MEMBERS)) {
            getThePrize(participants.findPersonByName(name), prizeLocation);
        }
    }

    private static void getTheAllPrizeList(Participants participants, PrizeLocation prizeLocation) {
        System.out.println("실행 결과");
        String[] names = participants.toString().split(" ");
        System.out.println(
                Arrays
                        .stream(names)
                        .map(it -> it.concat(" : " + prizeLocation.getPrizeIntoLocation(participants.findPersonByName(it).printCurrentPosition().getPosition())))
                        .collect(Collectors.joining("\n"))
        )
        ;
    }

    private static void getThePrize(Person personByName, PrizeLocation prizeLocation) {
        System.out.println("실행 결과");
        System.out.println(prizeLocation.getPrizeIntoLocation(personByName.printCurrentPosition().getPosition()));
    }

    private static void printPrizeList(PrizeLocation prizeLocation) {
        System.out.println(prizeLocation.toString());
    }

    private static void askTheResultofPerson() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public static void Banner() {
        System.out.println("실행결과");
        System.out.println();
    }

    public static void printNameList(Participants participants) {
        System.out.println(participants.toString());
    }

    public static void printLadder(Ladder ladder) {
        int height = ladder.getHeightOfLadder();
        for (int loop = 0; loop < height; loop++) {
            printLine(ladder.getLineOfHeight(loop));
        }
    }

    private static void printLine(Line line) {
        StringBuffer lineView = new StringBuffer();
        lineView.append(INITIAL_LINE);
        for (int loop = 0; loop < line.getNumberOfRung(); loop++) {
            drawRung(lineView, line.getRungOfPosition(loop));
        }
        System.out.println(lineView);
    }

    private static void drawRung(StringBuffer lineView, boolean rung) {
        if (rung) {
            lineView.append(RUNG_CONDITION_TRUE);
        }
        if (!rung) {
            lineView.append(RUNG_CONDITION_FALSE);
        }
    }
}
