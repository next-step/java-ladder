package nextstep.ladder.domain.name;

import nextstep.ladder.domain.common.AbstractValueList;

import java.util.List;

import static nextstep.ladder.domain.util.StringParserUtil.parseInputString;

public class Names extends AbstractValueList<Name> {
    public Names(String input) {
        this(parseInputString(input, Name::new));
    }

    public Names(List<Name> nameList) {
        super(nameList);
    }
}
