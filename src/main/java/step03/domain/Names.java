package step03.domain;

import exception.DuplicatedNameException;
import exception.InvalidCountOfNamesException;
import exception.NotFoundNameException;
import step03.utils.Tokenizer;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {
    private static final int MIN_COUNT_OF_NAMES = 2;
    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names of(String names) {
        return new Names(parseNames(names));
    }

    private static List<String> tokenizeNames(String names) {
        return Tokenizer.tokenizeWithComma(names);
    }

    private static void validate(List<String> nameTokens) {
        if (isInValidCount(nameTokens)) {
            throw new InvalidCountOfNamesException();
        }
    }

    public void validateUnique() {
        if (names.stream().distinct().count() != names.size()) {
            throw new DuplicatedNameException();
        }
    }

    private static boolean isInValidCount(List<String> nameTokens) {
        return nameTokens.size() < MIN_COUNT_OF_NAMES;
    }

    private static List<Name> parseNames(String names) {
        List<String> nameTokens = tokenizeNames(names);
        validate(nameTokens);

        return nameTokens.stream()
                .map(Name::of)
                .collect(Collectors.toList());
    }

    public int size() {
        return names.size();
    }

    public List<String> getNames() {
        return names.stream()
                .map(Name::toString)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    public void validateProhibitNames(String prohibitName) {
        names.forEach(name -> name.validateProhibitName(prohibitName));
    }

    public int indexOf(String targetName) {
        int index = names.indexOf(Name.of(targetName));
        if (index == -1) {
            throw new NotFoundNameException();
        }
        return index;
    }
}
