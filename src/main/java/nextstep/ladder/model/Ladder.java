package nextstep.ladder.model;

import nextstep.ladder.utils.StringUtils;

public class Ladder {
    private static final String DELIMITER = ",";

    private final Players players;
    private final Lines lines;

    public Ladder(String names, int height) {
        String[] splitNames = StringUtils.validationNotNullAndEmpty(names).split(DELIMITER);
        this.players = new Players(splitNames);
        this.lines = new Lines(splitNames.length, height);
    }

    @Override
    public String toString() {
        return players.toString() + "\n" +
                lines.toString();
    }
}
