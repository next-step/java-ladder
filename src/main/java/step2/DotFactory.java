package step2;

public class DotFactory {
    public static Dot single(final String ch) {
        return new SingleDot(ch);
    }

    public static Dot named(final String name) {
        return new NameDot(name);
    }
}
