package nextstep.ladder.domain.line;

import java.util.List;

import nextstep.ladder.domain.PlayerCount;

@FunctionalInterface
public interface LineGenerateStrategy {
    List<Boolean> generate(final PlayerCount playerCount);
}