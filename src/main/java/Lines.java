import java.util.List;

public class Lines {
    private final List<Line> values;

    public Lines(List<Line> values) {
        this.values = values;
    }

    public int height() {
        return values.size();
    }

    public Line heightAt(int height) {
        return this.values.get(height);
    }

    public void appendLines(StringBuilder sb) {
        for (Line line : this.values) {
            sb.append(line.toString());
            sb.append("\n");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lines lines = (Lines) o;

        return this.values.equals(lines.values);
    }
}
