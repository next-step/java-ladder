package nextstep.ladder.controller.view;

import nextstep.ladder.domain.gift.Gift;
import nextstep.ladder.domain.gift.GiftBundle;
import nextstep.ladder.domain.ladder.*;
import nextstep.ladder.domain.point.Point;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class OutputView {

    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String DELIMITER = "  ";
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-----";
    private static final String BLANK = "     ";
    private static final int STRING_BUFFER_EMPTY_LENGTH = 0;

    private OutputView() {
    }

    public static void showRadderGame(LadderGame ladderGame, GiftBundle giftBundle) {
        System.out.println();
        showParticipants(ladderGame.participants());
        showLadder(ladderGame.getLadder());
        showGifts(giftBundle.gifts());
    }

    public static void showParticipants(List<Participant> participants) {
        System.out.println(joinNameOfParticipants(participants));
    }

    private static String joinNameOfParticipants(List<Participant> participants) {
        return participants.stream()
                .map(Participant::getName)
                .collect(joining(DELIMITER));
    }

    private static void showLadder(Ladder ladder) {
        ladder.ladderLines()
                .forEach(OutputView::showLadderLine);
    }

    private static void showLadderLine(LadderLine ladderLine) {
        ladderLine.pointsExceptLast()
                .forEach(OutputView::showWay);

        STRING_BUILDER.append(VERTICAL);
        flush();
    }

    private static void showWay(Point point) {
        STRING_BUILDER.append(VERTICAL);

        if (point.existedRightWay()) {
            STRING_BUILDER.append(HORIZONTAL);
            return;
        }
        STRING_BUILDER.append(BLANK);
    }

    private static void showGifts(List<Gift> gifts) {
        System.out.println(joinNameOfGifts(gifts));
    }

    private static String joinNameOfGifts(List<Gift> gifts) {
        return gifts.stream()
                .map(Gift::getName)
                .collect(joining(DELIMITER));
    }

    private static void flush() {
        System.out.println(STRING_BUILDER);
        STRING_BUILDER.setLength(STRING_BUFFER_EMPTY_LENGTH);
    }

    public static void showWinningGift(Gift winningGift) {
        System.out.println("\n실행결과");
        System.out.println(winningGift.getName());
    }

    public static void showAllResults(GameResult gameResult) {
        System.out.println("\n실행결과");
        gameResult.results()
                .forEach(OutputView::showGiftWithParticipant);
    }

    private static void showGiftWithParticipant(Participant participant, Gift gift) {
        System.out.printf("%s : %s%n", participant.getName(), gift.getName());
    }
}
