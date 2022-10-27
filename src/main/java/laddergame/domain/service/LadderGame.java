package laddergame.domain.service;

import laddergame.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final People people;
    private final Rewards rewards;
    private final Ladder ladder;

    public LadderGame(People people, Rewards rewards, Ladder ladder) {
        this.people = people;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public static LadderGame of(People people, Rewards rewards, int countOfLadder) {
        return new LadderGame(people, rewards, Ladder.of(countOfLadder, people.numberOfPeople()) );
    }

    public List<PersonName> getPersonNames() {
        return people.getNames();
    }

    public Map<PersonName, Reward> makeResult(PersonName personName) {

        if (personName.isAll()) {
            return makeResultAll();
        }
        if (people.contains(personName)) {
            return makeResultOne(personName);
        }
        throw new IllegalArgumentException();
    }

    private Map<PersonName, Reward> makeResultOne(PersonName personName) {
        Map<PersonName, Reward> result = new HashMap<>();
        int rewardIndex = ladder.findRewardIndex(people.getIndex(personName));
        result.put(personName, rewards.getReward(rewardIndex));
        return result;
    }

    private Map<PersonName, Reward> makeResultAll() {
        HashMap<PersonName, Reward> result = new HashMap<>();

        List<PersonName> names = people.getNames();
        for (PersonName name : names) {
            int rewardIndex = ladder.findRewardIndex(people.getIndex(name));
            result.put(name, rewards.getReward(rewardIndex));
        }

        return result;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Rewards getRewards() {
        return rewards;
    }
}
