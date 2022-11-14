package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderCreator;
import nextstep.ladder.domain.LadderCreatorImpl;
import nextstep.ladder.domain.LadderLineCreator;
import nextstep.ladder.domain.LadderLineCreatorImpl;
import nextstep.ladder.domain.PlayerName;
import nextstep.ladder.domain.PlayerNames;
import nextstep.ladder.domain.PositiveNumber;
import nextstep.ladder.domain.RandomValueGenerator;
import nextstep.ladder.domain.RandomWrapper;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Application {

    public static void main(final String[] args) {
        final PlayerNames playerNames = getPlayerNames();
        final PositiveNumber ladderHeight = getLadderHeight();
        final PositiveNumber ladderWidth = getLadderWidth(playerNames);

        final Ladder ladder = getLadder(ladderHeight, ladderWidth);

        ResultView.printResult(playerNames.getNames(), ladder.getLadderLines());
    }

    private static PlayerNames getPlayerNames() {
        return new PlayerNames(mapToPlayerNameList(InputView.getPlayerNames()));
    }

    private static PositiveNumber getLadderHeight() {
        return new PositiveNumber(InputView.getLadderHeight());
    }

    private static PositiveNumber getLadderWidth(final PlayerNames playerNames) {
        return new PositiveNumber(playerNames.size());
    }

    private static Ladder getLadder(final PositiveNumber ladderHeight, final PositiveNumber ladderWidth) {
        final LadderCreator ladderCreator = getLadderCreator();
        return ladderCreator.create(ladderHeight, ladderWidth);
    }

    private static LadderCreator getLadderCreator() {
        return new LadderCreatorImpl(getLadderLineCreator());
    }

    private static LadderLineCreator getLadderLineCreator() {
        return new LadderLineCreatorImpl(getRandomValueGenerator());
    }

    private static RandomValueGenerator getRandomValueGenerator() {
        return RandomWrapper.getInstance();
    }

    private static List<PlayerName> mapToPlayerNameList(final String[] playerNames) {
        return Arrays.stream(playerNames)
            .map(String::trim)
            .map(PlayerName::valueOf)
            .collect(Collectors.toUnmodifiableList());
    }
}
