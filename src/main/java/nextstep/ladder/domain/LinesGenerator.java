package nextstep.ladder.domain;

public interface LinesGenerator {
    Lines generate(int rowCount, int colCount);

    void validateColCount(int colCount);
}
