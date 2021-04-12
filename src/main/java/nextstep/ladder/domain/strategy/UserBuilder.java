package nextstep.ladder.domain.strategy;

import java.util.List;
import nextstep.ladder.domain.Line;

public class UserBuilder implements BridgeBuilder {
    private final List<String> buildMap;

    public UserBuilder(List<String> buildMap) {
        this.buildMap = buildMap;
    }

    @Override
    public void build(List<Line> ladderLines) {
        // TODO buildMap에 따라 사다리 긋기
    }
}
