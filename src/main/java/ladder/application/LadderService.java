package ladder.application;

import ladder.domain.DefaultLinesGenerator;
import ladder.domain.LadderGame;
import ladder.domain.LinesGenerator;

public class LadderService {
    private static final String NAME_SEPARATOR = ",";
    private static final int MINIMUM_NUMBER_OF_PLAYERS = 2;

    public LadderGame make(final String inputName, final int height) {
        final String[] playNames = inputName.split(NAME_SEPARATOR);
        validate(playNames);
        final LinesGenerator linesGenerator = new DefaultLinesGenerator(playNames.length, height);
        return new LadderGame(playNames, linesGenerator);
    }

    private void validate(final String[] playNames) {
        if (playNames.length < MINIMUM_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("최소 2명부터 함께 할 수 있습니다.");
        }
    }
}
