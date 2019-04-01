package domain;

import generator.BooleansGenerator;
import generator.impl.NonContinuousGenerator;
import generator.impl.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Ladder {

    private final List<Boolean> lines;

    public Ladder(int length, BooleanSupplier booleanSupplier) {
        this.lines = Collections.unmodifiableList(createLines(length, booleanSupplier));
    }

    private List<Boolean> createLines(int length, BooleanSupplier booleanSupplier) {
        BooleansGenerator generator = new NonContinuousGenerator(booleanSupplier, true);

        List<Boolean> lines = new ArrayList<>();
        lines.add(Boolean.FALSE);
        lines.addAll(generator.generate(length - 1));

        return lines;
    }

    public List<Boolean> getLines() {
        return this.lines;
    }
}
