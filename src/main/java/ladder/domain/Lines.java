package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    private List<Line> lines = new ArrayList<>();

    public Lines(int height, int countOfPerson) {
        if(validate(height)) {
            throw new IllegalArgumentException("높이값 오류");
        }
        for (int i = 0; i < height; i++) {
            this.lines.add(new Line(countOfPerson));
        }
    }

    private boolean validate(int height) {
        return height < 1;
    }

    public int getLineHeight() {
        return this.lines.size();
    }

    public String drawLine() {
        return lines.stream()
                .map(line -> line.drawLine() + "\n")
                .collect(Collectors.joining());
    }

}
