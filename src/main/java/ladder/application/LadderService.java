package ladder.application;

import ladder.domain.DefaultLinesGenerator;
import ladder.domain.LadderGame;
import ladder.domain.LinesGenerator;

public class LadderService {
    private static final String NAME_SEPARATOR = ",";

    public LadderGame make(final String inputName, final int height) {
        final String[] playNames = inputName.split(NAME_SEPARATOR);
        final LinesGenerator linesGenerator = new DefaultLinesGenerator(playNames.length, height);
        return new LadderGame(playNames, linesGenerator);
    }
}
