package nextstep.ladder.domain.line;

@FunctionalInterface
public interface LineSelector {
    int select(int size);
}
