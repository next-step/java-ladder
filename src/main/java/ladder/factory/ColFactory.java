package ladder.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColFactory {

    private static final Random RANDOM = new Random();

    private Boolean before = false;

    public List<Boolean> cols(int col) {
        List<Boolean> cols = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            cols.add(col());
        }

        return cols;
    }

    private Boolean col() {
        Boolean col = RANDOM.nextBoolean();
        while (!creatable(col)) {
            col = RANDOM.nextBoolean();
        }
        before = col;
        return col;
    }

    private boolean creatable(Boolean current) {
        return !(before && current);
    }

}
