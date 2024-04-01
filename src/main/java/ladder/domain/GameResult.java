package ladder.domain;

import ladder.error.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {

    private final List<Reword> rewords;

    public GameResult(String inputText) {
        this(inputText.split(","));
    }

    public GameResult(String[] items) {
        this(getCollect(items));
    }

    private static List<Reword> getCollect(String[] items) {
        return Arrays.stream(items).map(Reword::new).collect(Collectors.toList());
    }

    public GameResult(List<Reword> rewords) {
        this.rewords = rewords;
    }

    public List<Reword> getRewords() {
        return rewords;
    }
}
