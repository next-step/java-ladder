package nextstep.ladder.engine;

import java.util.stream.Stream;

import nextstep.ladder.domain.Index;

public interface Line {
    Index move(int position);
    Stream<Boolean> boolStream();
}
