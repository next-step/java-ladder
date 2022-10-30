package laddergame.domain.service;

import laddergame.domain.Point;
import laddergame.domain.*;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<List<Boolean>> getLadderRecord() {
        return ladder.getLines()
                .stream()
                .map(this::makeLineRecord)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Boolean> makeLineRecord(Line line) {

        List<Point> points = line.getPoints();

        List<Boolean> records = new ArrayList<>();

        for (int i = 0; i < points.size() -1 ; i++) {
            records.add(points.get(i).isRight());
        }

        return Collections.unmodifiableList(records);
    }


    public Rewards getRewards() {
        return rewards;
    }
}
