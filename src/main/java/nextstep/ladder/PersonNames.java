package nextstep.ladder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonNames implements Iterable<Name> {
    private final List<Name> names;

    public PersonNames(String inputNames) {
        String[] inputs = inputNames.split(",");

        List<Name> nameList = new ArrayList<>();
        for (String input : inputs) {
            nameList.add(new Name(input.trim()));
        }

        this.names = nameList;
        validate(this.names);
    }

    private void validate(List<Name> names) {
        checkNameSizeIsValid(names);
    }

    private void checkNameSizeIsValid(List<Name> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("이름의 갯수는 최소 1개 이상이어야 합니다.");
        }
    }

    public int size() {
        return this.names.size();
    }

    @Override
    public Iterator<Name> iterator() {
        return this.names.iterator();
    }
}
