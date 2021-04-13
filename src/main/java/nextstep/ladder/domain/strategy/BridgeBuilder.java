package nextstep.ladder.domain.strategy;

import java.util.List;
import nextstep.ladder.domain.Line;

public interface BridgeBuilder {
    List<String> build(List<Line> ladderLines);
}
