package nextstep.ladder.controller;

import nextstep.ladder.controller.view.InputView;
import nextstep.ladder.controller.view.OutputView;
import nextstep.ladder.domain.exception.ServiceException;
import nextstep.ladder.domain.gift.Gift;
import nextstep.ladder.domain.gift.GiftBundle;
import nextstep.ladder.domain.ladder.GameResult;
import nextstep.ladder.domain.ladder.LadderGame;
import nextstep.ladder.domain.ladder.Participant;
import nextstep.ladder.domain.ladder.size.LadderHeight;
import nextstep.ladder.utils.Parser;

import java.util.List;

public class LadderController {

    private static final String END_CONDITION = "EXIT";
    private static final String ALL_CONDITION = "ALL";

    private LadderController() {
    }

    public static void main(String[] args) {
        try {
            start();
        } catch (ServiceException e) {
            System.out.println("\n잘못된 입력입니다: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n잠시후 다시 이용하세요");
        }
    }

    private static void start() {
        List<Participant> participants = createParticipants();
        GiftBundle giftBundle = createGiftBundle();
        LadderHeight ladderHeight = createLadderHeight();

        LadderGame ladderGame = LadderGame.of(participants, ladderHeight);
        OutputView.showRadderGame(ladderGame, giftBundle);

        keepShowingResultUntilEndCondition(ladderGame.play(giftBundle));
    }

    private static List<Participant> createParticipants() {
        List<String> names = Parser.split(InputView.getNames());
        return Participant.listOf(names);
    }

    private static GiftBundle createGiftBundle() {
        List<String> gifts = Parser.split(InputView.getGifts());
        return GiftBundle.from(gifts);
    }

    private static LadderHeight createLadderHeight() {
        return new LadderHeight(InputView.getHeight());
    }

    private static void keepShowingResultUntilEndCondition(GameResult gameResult) {
        boolean continued;
        do {
            continued = showResult(gameResult);
        } while (continued);
    }

    private static boolean showResult(GameResult gameResult) {
        String target = InputView.getTarget();

        if (END_CONDITION.equalsIgnoreCase(target)) {
            return false;
        }

        if (ALL_CONDITION.equalsIgnoreCase(target)) {
            OutputView.showAllResults(gameResult);
            return true;
        }
        showWinningGift(gameResult, target);
        return true;
    }

    private static void showWinningGift(GameResult gameResult, String target) {
        Participant participant = new Participant(target);
        Gift winningGift = gameResult.winningGift(participant);
        OutputView.showWinningGift(winningGift);
    }
}
