package nextstep.ladder.domain;

import java.util.List;

@FunctionalInterface
public interface LineGenerator {
    List<LinePoint> generate(LineLength length);
}
