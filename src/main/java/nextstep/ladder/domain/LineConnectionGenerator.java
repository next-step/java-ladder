package nextstep.ladder.domain;

@FunctionalInterface
public interface LineConnectionGenerator {
    Ladder generateConnection(int position);
}
