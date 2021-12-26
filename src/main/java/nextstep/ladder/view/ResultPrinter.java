package nextstep.ladder.view;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import nextstep.ladder.engine.GameResult;
import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Prize;

public class ResultPrinter {
    private static final String NAME_COLON = ":";

    private final String nameOfUser;
    private final GameResult gameResult;

    public ResultPrinter(String nameOfUser, GameResult gameResult) {
        this.nameOfUser = nameOfUser;
        this.gameResult = gameResult;
    }

    public Optional<String> mapNotExistUser() {
        return Optional.of(nameOfUser)
                .filter(Command.ALL_COMMAND::equalsIgnoreCase)
                .map(this::parseAllResult);
    }

    private String parseAllResult(String notUsed) {
        return gameResult.stream()
                .map(this::formatResult)
                .collect(Collectors.joining(OutputView.NEWLINE));
    }

    private String formatResult(Map.Entry<Name, Prize> entry) {
        return entry.getKey() + NAME_COLON + entry.getValue();
    }
}