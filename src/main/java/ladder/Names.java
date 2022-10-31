package ladder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import ladder.exception.EmptyNamesException;
import ladder.exception.InvalidNameLengthException;
import ladder.exception.NullNamesException;
import ladder.exception.UnknownNameException;

public class Names {

    private final List<String> names;
    private final int maxNameLength;

    public Names(List<String> names) {
        this.names = validateNames(names);
        this.maxNameLength = getMaxNameLength(names);
    }

    public List<String> getNames() {
        return this.names;
    }

    public int getMaxNameLength() {
        return this.maxNameLength;
    }

    public int getCountOfPerson() {
        return this.names.size();
    }

    public int getIndex(String name) {
        int index = this.names.indexOf(name);
        if(index == -1) {
            throw new UnknownNameException();
        }
        return index;
    }

    private List<String> validateNames(List<String> names) {
        long count = Optional.ofNullable(names)
                .orElseThrow(NullNamesException::new)
                .size();
        if (count == 0) {
            throw new EmptyNamesException();
        }
        return names;
    }

    private int getMaxNameLength(List<String> names) {
        List<String> sortedNames = names.stream()
                .sorted((left, right) -> right.length() - left.length())
                .collect(Collectors.toUnmodifiableList());

        validateNameLength(sortedNames);
        return sortedNames.get(0).length();
    }

    private void validateNameLength(List<String> sortedNames) {
        if (sortedNames.stream()
                .anyMatch(name -> name.length() == 0 || name.length() > 5)) {
            throw new InvalidNameLengthException();
        }
    }

}
