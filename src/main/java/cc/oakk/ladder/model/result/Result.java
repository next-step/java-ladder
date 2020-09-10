package cc.oakk.ladder.model.result;

import cc.oakk.ladder.util.StringUtils;
import cc.oakk.ladder.view.printer.Printable;
import cc.oakk.ladder.view.printer.Printer;

import java.util.Objects;

public class Result implements Printable<Result> {
    private final String name;

    public Result(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("빈 값이 넘겨졌습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return Objects.equals(name, result.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public void print(Printer<Result> printer) {
        printer.print(this);
    }
}
