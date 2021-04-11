package nextstep;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<String> names;

    public Players(String[] names) {
        this.names = new ArrayList<>();
        for (String name : names) {
            this.names.add(name);
        }
    }

    public String names() {
        return names.toString();
    }
}
