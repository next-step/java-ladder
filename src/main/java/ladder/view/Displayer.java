package ladder.view;

import java.util.function.Consumer;

@FunctionalInterface
public interface Displayer {
    void show(Consumer<String> displayer);
}
