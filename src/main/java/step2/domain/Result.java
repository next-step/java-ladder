package step2.domain;

public class Result {
    private final int personIndex;
    private final int resultIndex;

    public Result(int personIndex, int resultIndex) {
        this.personIndex = personIndex;
        this.resultIndex = resultIndex;
    }

    @Override
    public String toString() {
        return "Result{" +
                "personIndex=" + personIndex +
                ", resultIndex=" + resultIndex +
                '}';
    }
}
