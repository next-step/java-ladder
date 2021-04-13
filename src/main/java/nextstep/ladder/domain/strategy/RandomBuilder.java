package nextstep.ladder.domain.strategy;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.Line;

public class RandomBuilder implements BridgeBuilder {

    @Override
    public List<String> build(List<Line> ladderLines) {
        // TODO Random으로 그리기
        return new ArrayList<>();
    }
}
