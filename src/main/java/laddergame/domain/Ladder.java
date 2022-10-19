package laddergame.domain;

import laddergame.domain.linepainter.RandomLinePainter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final PersonName ALL = new PersonName("all");

    private final List<Line> lines;
    private final People people;
    private final Rewards rewards;

    public Ladder(People people, int countOfLadder, Rewards rewards) {
        this(IntStream.range(0, countOfLadder)
                        .mapToObj(__ -> new Line(people.numberOfPeople(), new RandomLinePainter()))
                        .collect(Collectors.toUnmodifiableList()),
                people,
                rewards);
    }

    public Ladder(List<Line> lines, People people, Rewards rewards) {
        this.lines = lines;
        this.people = people;
        this.rewards = rewards;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public List<PersonName> getPersonNames() {
        return people.getNames();
    }

    public Map<PersonName, Reward> getResult(PersonName personName) {

        if (ALL.equals(personName)) {
            return getResultAll(rewards);
        }

        if (people.contains(personName)) {
            return getResultOne(personName, rewards);
        }
        throw new IllegalArgumentException();
    }

    private Map<PersonName, Reward> getResultOne(PersonName personName, Rewards rewards) {

        HashMap<PersonName, Reward> result = new HashMap<>();
        result.put(personName, rewards.getReward(getResultIndex(people.getIndex(personName))));

        return result;
    }

    private int getResultIndex(int index) {
        for (Line line : lines) {
            index = line.nextIndex(index);
        }
        return index;
    }

    private Map<PersonName, Reward> getResultAll(Rewards rewards) {

        HashMap<PersonName, Reward> result = new HashMap<>();

        List<PersonName> names = people.getNames();
        for (PersonName name : names) {
            result.put(name, rewards.getReward(getResultIndex(people.getIndex(name))));
        }

        return result;
    }

    public List<Reward> getRewards() {
        return rewards.getRewardAll();
    }
}
