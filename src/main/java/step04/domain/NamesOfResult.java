package step04.domain;

import java.util.List;
import java.util.Objects;

public class NamesOfResult {
    private final Names names;

    private NamesOfResult(Names names) {
        this.names = names;
    }

    public static NamesOfResult of(String names) {
        return new NamesOfResult(Names.of(names));
    }

    public List<String> getNames() {
        return names.getNames();
    }

    public int size() {
        return names.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamesOfResult that = (NamesOfResult) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
