package nextstep.step2.view;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.LadderGame;
import nextstep.step2.domain.Line;
import nextstep.step2.dto.GameResult;
import nextstep.step2.dto.GameResults;
import nextstep.step2.vo.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final int NUMBER_OF_SPACE_BETWEEN_NAMES = 7;
    private static final String SPACE = " ";
    private static final String LADDER_SPACE = "     ";
    private static final String LADDER = "|";
    private static final String BRIDGE = "-----";

    public void renderLadder(LadderGame game) {
        System.out.println("실행 결과");
        System.out.println(namesToPrintString(game.getGameInfo().getNames()));
        System.out.println(ladderToPrintString(game.getLadder()));
        System.out.println(giftsToPrintString(game.getGameInfo().getGifts()));
    }

    public String namesToPrintString(Names names) {
        return names.getNames().stream()
                .map(this::nameToPintString)
                .collect(Collectors.joining());
    }

    public String giftsToPrintString(Gifts gifts) {
        return gifts.getGifts().stream()
                .map(this::giftToPintString)
                .collect(Collectors.joining());
    }

    private String nameToPintString(Name name) {
        StringBuilder builder = new StringBuilder();
        builder.append(name.getValue());
        for (int i = name.length(); i < NUMBER_OF_SPACE_BETWEEN_NAMES; i++) {
            builder.append(SPACE);
        }
        return builder.toString();
    }

    private String giftToPintString(Gift gift) {
        StringBuilder builder = new StringBuilder();
        builder.append(gift.getValue());
        for (int i = gift.length(); i < NUMBER_OF_SPACE_BETWEEN_NAMES; i++) {
            builder.append(SPACE);
        }
        return builder.toString();
    }

    public String ladderToPrintString(Ladder ladder) {
        return ladder.lineList().stream()
                .map(this::lineToPrintString)
                .collect(Collectors.joining("\n"));
    }

    private String lineToPrintString(Line line) {
        StringBuilder builder = new StringBuilder();
        builder.append(LADDER_SPACE);
        builder.append(LADDER);
        builder.append(
                line.getBridges().subList(0, line.getBridges().size() - 1).stream()
                        .map(this::bridgeToPrintString)
                        .collect(Collectors.joining(LADDER))
        );
        builder.append(LADDER);
        return builder.toString();
    }

    private String bridgeToPrintString(Bridge bridge) {
        if (bridge.equals(Bridge.RIGHT)) {
            return BRIDGE;
        }
        return LADDER_SPACE;
    }

    public void renderResults(GameResults gameResults) {
        List<GameResult> gameResultList = gameResults.getGameResults();
        for (GameResult gameResult : gameResultList) {
            System.out.println(gameResult.getName().getValue() + " : " + gameResult.getGift().getValue());
        }
    }

    public void renderResult(GameResult gameResult) {
        System.out.println(gameResult.getGift().getValue());
    }
}
