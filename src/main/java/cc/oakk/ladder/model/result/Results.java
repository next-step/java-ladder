package cc.oakk.ladder.model.result;

import cc.oakk.ladder.view.printer.Printable;
import cc.oakk.ladder.view.printer.Printer;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static cc.oakk.ladder.util.ValidationUtils.*;

public class Results implements Printable<Results> {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = Collections.unmodifiableList(throwIfEmptyList(results));
    }

    public Result get(int index) {
        throwIfOutOfListSize(results, index);
        return results.get(index);
    }

    public int size() {
        return results.size();
    }

    public Results forEach(Consumer<Result> consumer) {
        results.forEach(throwIfNull(consumer));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public void print(Printer<Results> printer) {
        printer.print(this);
    }
}
