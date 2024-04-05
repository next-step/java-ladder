package domain;

import java.util.Collection;
import java.util.List;

public interface LadderVisitor {

    void visit(List<Line> line, int height);

    void visit(List<Player> players);

    void visit(Collection<Reward> rewards);
}
