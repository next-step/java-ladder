package step2.util;

import step2.util.SidelineGenerator;

import java.util.List;

public abstract class SidelineGeneratorDecorator implements SidelineGenerator {
    private final SidelineGenerator sidelineGenerator;

    public SidelineGeneratorDecorator(SidelineGenerator sidelineGenerator) {
        this.sidelineGenerator = sidelineGenerator;
    }

    @Override
    public List<Boolean> generate() {
        return sidelineGenerator.generate();
    }
}
