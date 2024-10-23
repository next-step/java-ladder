package nextstep.ladder.view.output;

import nextstep.ladder.Visible;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.MatchResult;
import nextstep.ladder.domain.Player;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class ListView implements Visible {

    @Override
    public final void view(MatchResult matchResult, Ladder ladder) {
        System.out.println(viewList(getList(matchResult)));
    }

    private String viewList(Collection<String> strings) {
        return strings.stream()
                .map(name -> getWhiteSpace(name) + name)
                .collect(Collectors.joining(" "));
    }

    private String getWhiteSpace(String name) {
        return Stream.of(new String[Player.NAME_LIMIT - name.length()])
                .map(i -> " ")
                .collect(Collectors.joining());
    }

    protected abstract Collection<String> getList(MatchResult matchResult);
}
