package ladder.domain;

public class Rope {
    private final boolean value;

    private Rope(boolean value) {
        this.value = value;
    }

    public boolean exist() {
        return value;
    }

    public static Rope of(Boolean value) {
        return value ? InnerLazyClass.PRESENT : InnerLazyClass.EMPTY;
    }

    public static Rope present() {
        return InnerLazyClass.PRESENT;
    }

    public static Rope empty() {
        return InnerLazyClass.EMPTY;
    }

    private static class InnerLazyClass {
        private static Rope PRESENT = new Rope(true);
        private static Rope EMPTY = new Rope(false);
    }
}
