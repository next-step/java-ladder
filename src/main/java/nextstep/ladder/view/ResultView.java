package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;

import java.util.List;

public interface ResultView {
    void print(List<String> names, Ladder ladder);
}
