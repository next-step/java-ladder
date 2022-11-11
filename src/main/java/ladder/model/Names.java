package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Names {

    private List<Name> names = new ArrayList<>();

    public Names(String inputNames) {
        splitNames(inputNames);
    }

    private void splitNames(String inputNames) {
        String[] splitNames = inputNames.split(",");
        for (String splitName : splitNames) {
            Name name = new Name(splitName);
            validateDuplicate(name);
            names.add(name);
        }
    }

    private void validateDuplicate(Name name) {
        if (names.contains(name)) {
            throw new IllegalArgumentException("이름이 중복되었습니다.");
        }
    }

    public List<Name> getNames() {
        return names;
    }

    public int size() {
        return names.size();
    }
}
