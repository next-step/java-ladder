package domain;

import java.util.Collection;
import java.util.List;

public interface LadderVisitor {

    void visit(List<Player> players);

    void visit(Collection<Reward> rewards);

    void visitBridges(List<Bridges> bridges);
}
