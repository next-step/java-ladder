package nextstep.ladder.engine;

import java.util.Map;

import nextstep.ladder.domain.Index;

public interface ResultMapComposer {
    Map<Prize, Index> compose();
}
