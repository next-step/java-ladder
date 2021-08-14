package step2;

import java.util.List;

public abstract class SidelineGeneratorDecorator implements SidelineGenerator {
    private final SidelineGenerator sidelineGenerator;

    public SidelineGeneratorDecorator(SidelineGenerator sidelineGenerator) {
        this.sidelineGenerator = sidelineGenerator;
    }

    @Override
    public List<Boolean> generate(int n) {
        return sidelineGenerator.generate(n);
    }
}
