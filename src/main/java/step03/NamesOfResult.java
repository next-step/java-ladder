package step03;

import step03.domain.Name;
import step03.utils.Tokenizer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NamesOfResult {
    private final List<Name> name;

    private NamesOfResult(List<Name> name) {
        this.name = name;
    }

    public static NamesOfResult of(String names) {
        List<Name> tokenizedNames = tokenize(names);

        return new NamesOfResult(tokenizedNames);
    }

    private static List<Name> tokenize(String names) {
        return Tokenizer.tokenizeWithComma(names)
                .stream().map(Name::of)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamesOfResult that = (NamesOfResult) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
