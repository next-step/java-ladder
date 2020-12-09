package ladder.model.name;

@FunctionalInterface
public interface NamingConditional {
    boolean condition(int nameLength);
}

