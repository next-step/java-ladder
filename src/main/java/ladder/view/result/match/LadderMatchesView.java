package ladder.view.result.match;

import ladder.model.LadderMatch;
import ladder.view.View;

import java.util.List;

public class LadderMatchesView implements View {
    private final List<LadderMatch> matches;

    public LadderMatchesView(List<LadderMatch> matches) {
        this.matches = matches;
    }

    @Override
    public void render() {
        matches.forEach(match -> {
            System.out.println(match.name() + " : " + match.result());
        });
    }
}
