package nextstep.ladder.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ValidInputHelper {
    private ValidInputHelper() {

    }

    public static <T> T get(Supplier<T> inputDevice, Consumer<RuntimeException> errorPrinter) {
        try {
            return inputDevice.get();
        } catch (RuntimeException e) {
            errorPrinter.accept(e);
            return get(inputDevice, errorPrinter);
        }
    }
}
