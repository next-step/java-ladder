package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class PersonNames {
    private final List<Name> names;

    public PersonNames(String inputNames) {
        String[] inputs = inputNames.split(",");

        List<Name> nameList = new ArrayList<>();
        for (String input : inputs) {
            nameList.add(new Name(input.trim()));
        }

        this.names = nameList;
    }
}
