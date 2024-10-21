package nextstep.ladder.view.output;

import nextstep.ladder.Visible;
import nextstep.ladder.domain.GameOrganizer;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class ListView implements Visible {

    @Override
    public final void view(GameOrganizer gameOrganizer, Ladder ladder) {
        System.out.println(viewList(getList(gameOrganizer)));
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

    protected abstract List<String> getList(GameOrganizer gameOrganizer);
}
