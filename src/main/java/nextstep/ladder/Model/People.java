package nextstep.ladder.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class People {

    private static final String MIN_MEMBER_ERROR = "게임을 하려면 최소 2명이어야 합니다.";
    private static final String NOT_CONTAIN_PERSON = "일치하는 사용자가 존재하지 않습니다.";
    private static final int STANDARD_GAME = 2;
    private final List<Person> people;

    public People(List<Person> people) {
        validate(people);
        this.people = people;
    }

    public void offerReward(Ladder ladder, Rewards rewards) {
        List<Reward> Rewards = IntStream.range(0, people.size())
                .map(it -> ladder.move(it))
                .mapToObj(it -> rewards.getRewardByLocation(it))
                .collect(Collectors.toList());
        for (int i = 0; i < people.size(); i++) {
            people.get(i).offerReward(Rewards.get(i));
        }
    }

    public Person getPersonByName(String name) {
        return people.stream()
                .filter(it -> it.equals(new Person(name)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_CONTAIN_PERSON));
    }

    private void validate(List<Person> people) {
        if (people.size() < STANDARD_GAME) {
            throw new IllegalArgumentException(MIN_MEMBER_ERROR);
        }
    }

    public int size() {
        return people.size();
    }

    public List<Person> getPeople() {
        return people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;
        People people1 = (People) o;
        return Objects.equals(getPeople(), people1.getPeople());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPeople());
    }
}
