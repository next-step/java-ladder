package ladder.domain.model.Param;

import ladder.domain.model.LadderHeight;
import ladder.exception.LadderHeightArgumentException;

import java.util.function.Supplier;

public class LadderHeightParam {
    private static int MINIMUM_HEIGHT = 1;

    private int height;

    public LadderHeightParam(int height) {
        if (isHeightNegative(height)) {
            throw new LadderHeightArgumentException("비어 있거나 잘못된 값을 입력하였습니다.");
        }
        this.height = height;
    }

    private boolean isHeightNegative(int height) {
        return height < MINIMUM_HEIGHT;
    }


    public LadderHeight convertParamToModel() {
        Supplier<LadderHeight> supplier = () -> new LadderHeight(height);
        return supplier.get();
    }
}
