package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.stream.Collectors;

public class ResultView {

    private static final String STRING_FORMAT_RENDDER = "%6s";
    private static final String GUIDE_HEAD_LINE = "실행 결과";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String EMPTY_LINE = "";

    public void printResult(Ladder ladder, Participants participants, LadderRewards ladderRewards) {
        printHeader();
        printNames(participants);
        printLadder(ladder);
        // TODO 사다리 결과 출력
        printLadderRewards(ladderRewards);
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

    private String parseName(Name name) {
        return String.format(STRING_FORMAT_RENDDER, name);
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

    private String parseFormat(String ladderReward) {
        return String.format(STRING_FORMAT_RENDDER, ladderReward);
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

    // TODO 사다리 타기 결과 정보 출력
    public void printUser(String user, LadderRewards ladderRewards) {

        printUserResult();
    }

    private void printUserResult() {

    }
}
