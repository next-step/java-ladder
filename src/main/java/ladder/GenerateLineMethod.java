package ladder;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class GenerateLineMethod implements Supplier {
    private Boolean ladder;
    private static final Random random = new Random();

    private GenerateLineMethod() {
        this.ladder = false;
    }

    public static GenerateLineMethod of() {
        return new GenerateLineMethod();
    }

    @Override
    public Boolean get() {
        ladder = ladder ? false : random.nextBoolean();
        return ladder;
    }
}
