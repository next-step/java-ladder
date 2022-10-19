package laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private List<Reward> values;

    public Rewards(List<Reward> inputs) {
        this.values = inputs;
    }

    public Rewards(String[] inputs) {
        this(Arrays.stream(inputs)
                .map(Reward::new)
                .collect(Collectors.toList()));
    }

    public int numberOfRewards(){
        return values.size();
    }

    public void validate(People persons) {
        if(persons.numberOfPeople() != values.size()){
            throw new IllegalArgumentException();
        }
    }
}
