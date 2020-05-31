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

    public int size() {
        return this.values.size();
    }

    public boolean get(int index) {
        return this.values.get(index);
    }

    public Points add(PointAddStrategy pointAddStrategy) {
        if (values.get(values.size() - 1)) {
            values.add(pointAddStrategy.confirmPointLocation(false));
            return new Points(new ArrayList<>(this.values));
        }
        values.add(pointAddStrategy.confirmPointLocation(true));
        return new Points(new ArrayList<>(this.values));
    }
}
