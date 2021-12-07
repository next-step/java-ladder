package nextstep.ladder.controller.view;

import nextstep.ladder.domain.gift.Gift;
import nextstep.ladder.domain.gift.GiftBundle;
import nextstep.ladder.domain.ladder.*;
import nextstep.ladder.domain.point.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final StringBuilder stringBuffer = new StringBuilder();
    private static final String DELIMITER = "  ";
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-----";
    private static final String BLANK = "     ";
    private static final int STRING_BUFFER_EMPTY_LENGTH = 0;
    private static final int INDEX_UNIT = 1;

    private OutputView() {
    }

    public static void showRadderGame(LadderGame ladderGame, GiftBundle giftBundle) {
        System.out.println();
        showParticipants(ladderGame.participants());
        showLadder(ladderGame.getLadder());
        showGifts(giftBundle.gifts());
    }

    public static void showParticipants(List<Participant> participants) {
        System.out.println(joinParticipants(participants));
    }

    private static String joinParticipants(List<Participant> participants) {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private static void showLadder(Ladder ladder) {
        ladder.ladderLines()
                .forEach(OutputView::showLadderLine);
    }

    private static void showLadderLine(LadderLine ladderLine) {
        stringBuffer.append(VERTICAL);

        List<Point> points = new ArrayList<>(ladderLine.points());
        removeLastPoint(points);

        for (Point point : points) {
            showWay(point);
            stringBuffer.append(VERTICAL);
        }
        flush();
    }

    private static void removeLastPoint(List<Point> points) {
        points.remove(points.size() - INDEX_UNIT);
    }

    private static void showWay(Point point) {
        if (point.existedRightWay()) {
            stringBuffer.append(HORIZONTAL);
            return;
        }
        stringBuffer.append(BLANK);
    }

    private static void showGifts(List<Gift> gifts) {
        System.out.println(joinGifts(gifts));
    }

    private static String joinGifts(List<Gift> gifts) {
        return gifts.stream()
                .map(Gift::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private static void flush() {
        System.out.println(stringBuffer);
        stringBuffer.setLength(STRING_BUFFER_EMPTY_LENGTH);
    }

    public static void showWinningGift(Gift winningGift) {
        System.out.println("\n실행결과");
        System.out.println(winningGift.getName());
    }

    public static void showAllResults(GameResult gameResult) {
        System.out.println("\n실행결과");
        gameResult.results()
                .forEach(OutputView::showWinningGiftWithParticipant);
    }

    private static void showWinningGiftWithParticipant(Participant participant, Gift gift) {
        System.out.printf("%s : %s%n", participant.getName(), gift.getName());
    }
}
