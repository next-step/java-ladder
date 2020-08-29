package ladder;

import ladder.ui.Input;
import ladder.ui.Output;

import java.util.List;

public class WhenUtils {

    public static Input input(String names, int height) {
        return new Input() {
            @Override
            public int nextInt() {
                return height;
            }

            @Override
            public String nextLine() {
                return names;
            }
        };
    }

    public static Output output() {
        return new Output() {
            @Override
            public void print(String line) {

            }

            @Override
            public void print(List<String> lineList) {

            }

            @Override
            public void printMultiLine(List<String> lineList) {

            }
        };
    }
}
