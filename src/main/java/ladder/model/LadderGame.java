package ladder.model;

public class LadderGame {
    private People people;
    private Rewards rewards;
    private  Ladder ladder;

    private LadderGame(String names, String rewards, int length) {
        int countOfPerson = validation(names, rewards);

        this.people = People.of(names);
        this.rewards = Rewards.of(rewards);
        this.ladder = Ladder.of(countOfPerson, length);
    }

    public static LadderGame of(String names, String rewards, int length) {
        return new LadderGame(names, rewards, length);
    }

    public People getPeople() {
        return people;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public Ladder getLadder() {
        return ladder;
    }

    private int validation(String names, String rewards) {
        int countOfPerson = names.split(",").length;
        int countOfReward = rewards.split(",").length;

        if(countOfPerson != countOfReward) {
            throw new IllegalArgumentException();
        }
        return countOfPerson;
    }
}

