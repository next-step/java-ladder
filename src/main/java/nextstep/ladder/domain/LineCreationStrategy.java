package nextstep.ladder.domain;

public interface LineCreationStrategy {
    boolean createLine();
    boolean isOrNoneDrawLines(Line line);
}
