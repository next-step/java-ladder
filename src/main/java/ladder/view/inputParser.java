package ladder.view;

import ladder.domain.data.PersonNames;

public class inputParser {

    public static PersonNames parse(String input) {
        return new PersonNames(input.split(","));
    }
}
