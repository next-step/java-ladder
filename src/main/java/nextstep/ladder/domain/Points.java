package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Points {
    List<Boolean> values;

    private Points(List<Boolean> values) {
        this.values = new ArrayList<>(values);
    }

    public static Points create() {
        return new Points(Collections.singletonList(false));
    }

    public boolean get(int index) {
        return this.values.get(index);
    }
}
