package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private People people;
    private Rewards rewards;
    private List<Line> lines;

    private Ladder(String names, String rewards, List<Line> lines) {
        this.people = People.of(names);
        this.rewards = Rewards.of(rewards);
        this.lines = lines;
    }

    public static Ladder of(String names, String rewards, int length) {
        List<Line> lines = new ArrayList<>();
        int countOfPerson = names.split(",").length;
        int countOfReward = rewards.split(",").length;

        if(countOfPerson != countOfReward) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < length; i++) {
            lines.add(Line.of(countOfPerson));
        }
        return new Ladder(names, rewards, lines);
    }

    public static Ladder of(String names, String rewards, List<Line> lines) {
        return new Ladder(names, rewards, lines);
    }

    public People getPeople() {
        return people;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ladder ladder = (Ladder) o;

        if (people != null ? !people.equals(ladder.people) : ladder.people != null) return false;
        return lines != null ? lines.equals(ladder.lines) : ladder.lines == null;
    }

    @Override
    public int hashCode() {
        int result = people != null ? people.hashCode() : 0;
        result = 31 * result + (lines != null ? lines.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "people=" + people +
                ", lines=" + lines +
                '}';
    }
}

