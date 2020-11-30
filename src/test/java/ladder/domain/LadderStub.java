package ladder.domain;

public class LadderStub extends Ladder{

    public LadderStub(int countOfPerson, int height) {
        super(countOfPerson, height);
    }

    @Override
    public MoveStrategy moveRule() {
        return () -> true;
    }
}
