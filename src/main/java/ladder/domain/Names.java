package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {
    public static final int MIN_PERSON_COUNT = 2;
    public static final int NOT_FOUND = -1;
    private List<Name> names;

    public Names(String[] requestName) {
        this(Arrays.stream(requestName)
                .map(name -> new Name(name))
                .collect(Collectors.toList()));
    }

    private Names(List<Name> names) {
        if (names.size() < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람 수가 너무 작습니다. 사람 수 : " + names.size());
        }
        this.names = names;
    }

    public int size() {
        return names.size();
    }

    public int indexOf(String name) {
        int nameIndex = names.indexOf(new Name(name));
        if (nameIndex == NOT_FOUND && !name.equals("all")) {
            throw new IllegalArgumentException("잘못된 이름입니다. name : " + name);
        }
        return nameIndex;
    }

    public Stream<Name> stream(){
        return names.stream();
    }
    public Name get(int index) {
        return names.get(index);
    }

}
