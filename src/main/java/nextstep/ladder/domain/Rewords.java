package nextstep.ladder.domain;

import java.util.List;

public class Rewords {

    private final List<String> rewords;

    private Rewords(List<String> rewords) {
        this.rewords = rewords;
    }

    public static Rewords from(List<String> rewords) {
        return new Rewords(rewords);
    }

    public String reword(Position position) {
        return rewords.get(position.currentPosition());
    }
}
