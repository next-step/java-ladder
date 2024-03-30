package nextstep.ladder.domain;

import nextstep.ladder.util.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participant implements Point{

    private final List<Name> name;

    public Participant(String names) {
        this(names.split(","));
    }

    public Participant(String[] names) {
        this(generateNames(names));
    }

    public Participant(List<Name> name) {
        if(name.size() <= 1){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    private static List<Name> generateNames(String[] names){
        return Arrays.stream(names)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public List<Boolean> generatePoints(){
        ArrayList<Boolean> points = new ArrayList<>();
        for(int i =0; i < name.size(); i++){
            points.add(RandomBooleanGenerator.generate());
        }
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participant)) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
