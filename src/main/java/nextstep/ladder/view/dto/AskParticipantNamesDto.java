package nextstep.ladder.view.dto;

import java.util.List;

import nextstep.ladder.domain.Names;
import nextstep.ladder.util.StringUtil;

public class AskParticipantNamesDto {
    private static final String NAME_SPLIT_DELIMITER = ",";
    private final Names names;

    private AskParticipantNamesDto(List<String> names) {
        this.names = Names.of(names);
    }

    public static AskParticipantNamesDto of(String unSplitedNames) {
        List<String> splitedNames = StringUtil.splitByDelimiter(unSplitedNames, NAME_SPLIT_DELIMITER);
        return new AskParticipantNamesDto(splitedNames);
    }

    public Names getNames() {
        return names;
    }
}
