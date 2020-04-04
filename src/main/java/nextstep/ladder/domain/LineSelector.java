package nextstep.ladder.domain;

@FunctionalInterface
public interface LineSelector {
    int select(int size);
}
