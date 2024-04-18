package ladder.domain;

import java.util.Arrays;

public enum ShowResultType {
    ALL("all"),
    INDIVIDUAL("");

    private final String resultCommand;

    ShowResultType(String resultCommand) {
        this.resultCommand = resultCommand;
    }

    public static ShowResultType get(String resultCommand) {
        return Arrays.stream(ShowResultType.values())
                .filter(showResultType -> showResultType.resultCommand.equals(resultCommand))
                .findAny()
                .orElse(INDIVIDUAL);
    }
}
