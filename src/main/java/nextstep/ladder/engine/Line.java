package nextstep.ladder.engine;

public interface Line {
    int size();

    boolean isPointTrue(int index);

    int movePerson(int startIndex);
}
