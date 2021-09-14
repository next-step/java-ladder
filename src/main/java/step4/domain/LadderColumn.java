package step4.domain;

import java.util.Arrays;
import java.util.List;

public class LadderColumn {
    List<String> names;

    public LadderColumn(String names) {
        this.names = Arrays.asList(names.split(","));
    }

    public String name(int index) {
        return names.get(index);
    }

    public int sizeOfPerson() {
        return names.size();
    }

    public List<String> names() {
        return names;
    }
}
