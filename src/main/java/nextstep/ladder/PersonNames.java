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
    }

    public int size() {
        return this.names.size();
    }

    @Override
    public Iterator<Name> iterator() {
        return this.names.iterator();
    }
}
