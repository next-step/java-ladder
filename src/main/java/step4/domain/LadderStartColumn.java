package step4.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LadderStartColumn {
    List<String> names;

    public LadderStartColumn(String names) {
        this.names = Arrays.asList(names.split(","));
    }

    public String name(int index) {
        return names.get(index);
    }
}
