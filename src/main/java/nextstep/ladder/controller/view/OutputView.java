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

public class OutputView {

    private static final StringBuilder stringBuffer = new StringBuilder();
    private static final String DELIMITER = "  ";
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-----";
    private static final String BLANK = "     ";
    private static final int STRING_BUFFER_EMPTY_LENGTH = 0;

    private OutputView() {
    }

    public static void showRadderResult(LadderGame ladderGame, GiftBundle giftBundle) {
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

    public static void showLadder(Ladder ladder) {
        ladder.lines()
                .forEach(OutputView::showLine);
    }

    private static void showLine(Line line) {
        stringBuffer.append(VERTICAL);
        for (boolean point : line.points()) {
            showPoint(point);
            stringBuffer.append(VERTICAL);
        }
        flush();
    }

    private static void showPoint(boolean point) {
        if (point) {
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

    public static void showWinningGiftsWithParticipant(Map<Participant, Gift> gameResults) {
        System.out.println("\n실행결과");
        gameResults.forEach(OutputView::showWinningGiftWithParticipant);
    }

    private static void showWinningGiftWithParticipant(Participant participant, Gift gift) {
        System.out.printf("%s : %s%n", participant.getName(), gift.getName());
    }

}
