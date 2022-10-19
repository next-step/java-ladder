package laddergame.domain.service;

import laddergame.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private static final PersonName ALL = new PersonName("all");

    private final People people;
    private final Rewards rewards;
    private final Ladder ladder;

    public LadderGame(People people, Rewards rewards, Ladder ladder) {
        this.people = people;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public LadderGame(People people, Rewards rewards, int countOfLadder) {
        this(people, rewards, new Ladder(countOfLadder, people.numberOfPeople()));
    }

    public List<PersonName> getPersonNames() {
        return people.getNames();
    }

    public Map<PersonName, Reward> getResult(PersonName personName) {

        if (ALL.equals(personName)) {
            return getResultAll();
        }
        if (people.contains(personName)) {
            return getResultOne(personName);
        }
        throw new IllegalArgumentException();
    }

    private Map<PersonName, Reward> getResultOne(PersonName personName) {
        Map<PersonName, Reward> result = new HashMap<>();
        result.put(personName, rewards.getReward(ladder.getResultIndex(people.getIndex(personName))));
        return result;
    }

    private Map<PersonName, Reward> getResultAll() {
        HashMap<PersonName, Reward> result = new HashMap<>();

        List<PersonName> names = people.getNames();
        for (PersonName name : names) {
            result.put(name, rewards.getReward(ladder.getResultIndex(people.getIndex(name))));
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
