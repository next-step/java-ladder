public class Result {
    private final String value;

    public Result(String value) {
        this.value = value;
    }

    public int length() {
        return value.length();
    }

    @Override
    public String toString() {
        return value;
    }
}
