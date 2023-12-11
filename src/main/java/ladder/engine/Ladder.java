package ladder.engine;

public interface Ladder {

    String INDENT = " ";

    Result runAll(int personOrder);

    Result run(int personOrder);

}
