package nextstep.ladder.model;

import nextstep.ladder.utils.StringUtils;

public class Ladder {
    private static final String DELIMITER = ",";

    private final Person person;
    private final Lines lines;

    public Ladder(String names, int height) {
        String[] splitNames = StringUtils.validationNotNullAndEmpty(names).split(DELIMITER);
        this.person = new Person(splitNames);
        this.lines = new Lines(splitNames.length, height);
    }

    @Override
    public String toString() {
        return person.toString() + "\n" +
                lines.toString();
    }
}
