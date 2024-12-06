import java.util.List;

public class Results {
    private final List<Result> values;

    public Results(List<Result> values) {
        this.values = values;
    }

    public String get(int i) {
        return values.get(i).toString();
    }

    public void appendResults(StringBuilder sb) {
        for (Result result : this.values) {
            sb.append(Constants.PADDING);
            sb.append(Constants.PADDING);
            sb.append(result);
            sb.append(" ".repeat(Math.max(0, 5 - result.length())));
        }
    }
}
