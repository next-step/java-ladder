package ladder.domain;

@FunctionalInterface
public interface LineFactory {

    Line create(Integer laneCount);
}
