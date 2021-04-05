package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String STRING_FORMAT_RENDER = "%6s";
    private static final String GUIDE_HEAD_LINE = "\n사다리 타기 결과\n";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String EMPTY_LINE = "";

    public void printResult(Ladder ladder, Participants participants, LadderRewards ladderRewards) {
        printHeader();
        printNames(participants);
        printLadder(ladder);
        printLadderRewards(ladderRewards);
        System.out.println();
    }

    private void printHeader() {
        System.out.println(GUIDE_HEAD_LINE);
    }

    private void printNames(Participants participants) {
        participants.getUsers()
                .stream()
                .map(this::parseName)
                .forEach(System.out::print);
        System.out.println();
    }

    private String parseName(User user) {
        return String.format(STRING_FORMAT_RENDER, user);
    }

    private void printLadder(Ladder ladder) {
        ladder.lines()
                .stream()
                .map(this::renderLadder)
                .forEach(System.out::println);
    }

    private void printLadderRewards(LadderRewards ladderRewards) {
        ladderRewards.getLadderRewards()
                .stream()
                .map(this::parseFormat)
                .forEach(System.out::print);
        System.out.println();
    }

    private String parseFormat(Reward ladderReward) {
        return String.format(STRING_FORMAT_RENDER, ladderReward);
    }

    private String renderLadder(Line line) {
        return line.points()
                .stream()
                .map(this::renderPerPoint)
                .collect(Collectors.joining(LADDER_VERTICAL_LINE, EMPTY_LINE, LADDER_VERTICAL_LINE));
    }

    private String renderPerPoint(Point point) {
        if(point.isExist()) {
            return LADDER_HORIZON;
        }
        return LADDER_EMPTY;
    }

    public void printUserResult(List<String> allUser) {
        System.out.println("\n실행 결과");
        allUser.forEach(System.out::println);
    }

    public void printUserResult(String user) {
        System.out.println("\n실행 결과");
        System.out.println(user);
    }
}
