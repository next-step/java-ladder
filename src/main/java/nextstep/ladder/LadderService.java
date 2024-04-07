package nextstep.ladder;

import java.util.List;

public class LadderService {
    private static final String NAME_DELIMITER = ",";

    public static List<String> splitNames(String inputNames) {
        return List.of(inputNames.split(NAME_DELIMITER));
    }

    public static int countUsers(List<String> nameList) {
        return nameList.size();
    }
}
