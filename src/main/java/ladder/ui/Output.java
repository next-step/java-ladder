package ladder.ui;

import java.util.List;

public interface Output {
    void print(String line);
    void print(List<String> lineList);
    void printMultiLine(List<String> lineList);
}
