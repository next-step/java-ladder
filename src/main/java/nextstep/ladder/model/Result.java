package nextstep.ladder.model;

public class Result {
    private Person person;
    private Reward reward;

    public Result(Person person, Reward reward) {
        this.person = person;
        this.reward = reward;
    }

    @Override
    public String toString() {
        return person + " : " + reward;
    }
}
