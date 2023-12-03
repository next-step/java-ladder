package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class People {
    public static final int MIN_PEOPLE_COUNT = 1;
    private final List<Name> names;

    public People(List<Name> names) {
        checkPeopleValidity(names);
        this.names = names;
    }

    public People(String... nameList) {
        this(
                Arrays.stream(nameList)
                        .map(Name::new)
                        .collect(Collectors.toList())
        );
    }

    private void checkPeopleValidity(List<Name> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("사람은 최소 " + MIN_PEOPLE_COUNT + "명 이상이어야 합니다.");
        }
    }

    public List<String> names() {
        return names.stream()
                .map(Name::name)
                .collect(Collectors.toList());
    }

    public String name(int index){
        return this.names.get(index).name();
    }

    public int count(){
        return this.names.size();
    }
}
