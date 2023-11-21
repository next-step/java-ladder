package ladder.fixture;

import ladder.factory.ColFactory;

import java.util.ArrayList;
import java.util.List;

public class FixedColFactory extends ColFactory {

    private List<Boolean> givenCols;

    public FixedColFactory(List<Boolean> givenCols) {
        this.givenCols = givenCols;
    }

    public List<Boolean> cols(int col) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            result.add(this.givenCols.get(i));
        }

        return result;
    }

}
