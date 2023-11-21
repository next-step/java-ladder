package ladder.view;

import ladder.domain.PersonNames;

public class inputParser {

    public static PersonNames parse(String input) {
        return new PersonNames(input.split(","));
    }
}
