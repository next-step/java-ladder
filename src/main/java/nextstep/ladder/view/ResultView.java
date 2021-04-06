package nextstep.ladder.view;

import nextstep.ladder.domain.*;
import nextstep.ladder.wrapper.Ladder;
import nextstep.ladder.wrapper.LadderRewards;
import nextstep.ladder.wrapper.Line;
import nextstep.ladder.wrapper.Participants;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class ResultView {

    private static final String STRING_FORMAT_RENDER = "%6s";
    private static final String GUIDE_HEAD_LINE = "\n사다리 타기 결과\n";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_EMPTY = "     ";
    private static final String EMPTY_LINE = "";

    public void printResult(final Ladder ladder, final Participants participants, final LadderRewards ladderRewards) {
        printHeader();
        printNames(participants);
        printLadder(ladder);
        printLadderRewards(ladderRewards);
        out.println();
    }

    private void printHeader() {
        out.println(GUIDE_HEAD_LINE);
    }

    private void printNames(final Participants participants) {
        participants.getUsers()
                .stream()
                .map(this::parseName)
                .forEach(out::print);
        out.println();
    }

    private String parseName(final User user) {
        return String.format(STRING_FORMAT_RENDER, user);
    }

    private void printLadder(final Ladder ladder) {
        ladder.lines()
                .stream()
                .map(this::renderLadder)
                .forEach(out::println);
    }

    private void printLadderRewards(final LadderRewards ladderRewards) {
        ladderRewards.getRewards()
                .stream()
                .map(this::parseFormat)
                .forEach(out::print);
        out.println();
    }

    private String parseFormat(final Reward ladderReward) {
        return String.format(STRING_FORMAT_RENDER, ladderReward);
    }

    private String renderLadder(final Line line) {
        return line.points()
                .stream()
                .map(this::renderPerPoint)
                .collect(Collectors.joining(LADDER_VERTICAL_LINE, EMPTY_LINE, LADDER_VERTICAL_LINE));
    }

    private String renderPerPoint(final Bar bar) {
        if(bar.isExist()) {
            return LADDER_HORIZON;
        }
        return LADDER_EMPTY;
    }

    public void printUserResult(final List<String> allUser) {
        out.println("\n실행 결과");
        allUser.forEach(out::println);
    }

    public void printUserResult(final String user) {
        out.println("\n실행 결과");
        out.println(user);
    }
}
