package nextstep.ladder.controller.view;

import nextstep.ladder.domain.gift.Gift;
import nextstep.ladder.domain.gift.GiftBundle;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderGame;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Participant;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class OutputView {

    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String DELIMITER = "  ";
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-----";
    private static final String BLANK = "     ";
    private static final int STRING_BUFFER_EMPTY_LENGTH = 0;

    private OutputView() {
    }

    public static void showRadderResult(LadderGame ladderGame, GiftBundle giftBundle) {
        newLine();
        showParticipants(ladderGame.participants());
        showLadder(ladderGame.getLadder());
        showGifts(giftBundle.gifts());
    }

    public static void showParticipants(List<Participant> participants) {
        println(joinParticipants(participants));
    }

    private static String joinParticipants(List<Participant> participants) {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    public static void showLadder(Ladder ladder) {
        ladder.lines()
                .forEach(OutputView::showLine);
    }

    private static void showLine(Line line) {
        STRING_BUILDER.append(VERTICAL);
        for (boolean point : line.points()) {
            showPoint(point);
            STRING_BUILDER.append(VERTICAL);
        }
        flushStringBuilder();
    }

    private static void showPoint(boolean point) {
        if (point) {
            STRING_BUILDER.append(HORIZONTAL);
            return;
        }
        STRING_BUILDER.append(BLANK);
    }

    private static void showGifts(List<Gift> gifts) {
        println(joinGifts(gifts));
    }

    private static String joinGifts(List<Gift> gifts) {
        return gifts.stream()
                .map(Gift::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private static void flushStringBuilder() {
        println(STRING_BUILDER);
        STRING_BUILDER.setLength(STRING_BUFFER_EMPTY_LENGTH);
    }

    public static void showWinningGift(Gift winningGift) {
        println("\n실행결과");
        println(winningGift.getName());
    }

    public static void showWinningGiftsWithParticipant(Map<Participant, Gift> gameResults) {
        println("\n실행결과");
        gameResults.forEach(OutputView::showWinningGiftWithParticipant);
    }

    private static void showWinningGiftWithParticipant(Participant participant, Gift gift) {
        println(format("%s : %s", participant.getName(), gift.getName()));
    }

    private static void println(StringBuilder stringBuilder) {
        System.out.println(stringBuilder.toString());
    }

    private static void println(String string) {
        System.out.println(string);
    }

    private static void newLine() {
        System.out.println();
    }

}
