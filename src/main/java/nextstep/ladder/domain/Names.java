package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {

    private static final String DELIMITER_COMMA = ",";
    private List<Name> playersName;

    public Names(String names) {
        this.playersName = from(names);
    }

    public List<Name> names() {
        return playersName;
    }

    public int size() {
        return names().size();
    }

    public int index(String target) {
        Name targetName = new Name(target);
        return playersName.indexOf(targetName);
    }

    private List<Name> from(String names) {
        List<String> playersName = splitByByComma(names);
        return playersName
            .stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

    private List<String> splitByByComma(String names) {
        List<String> playersName = new ArrayList<>();
        Collections.addAll(playersName, names.split(DELIMITER_COMMA));
        return playersName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Names names = (Names) o;
        return Objects.equals(playersName, names.playersName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playersName);
    }


}
