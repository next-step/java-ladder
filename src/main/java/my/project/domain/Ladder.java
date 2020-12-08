package my.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Users users, int height) {
        lines = new ArrayList<>();
        IntStream.range(Line.ZERO, height)
                .forEach(i -> lines.add(new Line(users.getUsers().size())));

        IntStream.range(Line.ZERO, height)
                .forEach(i -> {
                    IntStream.range(Line.ZERO, lines.get(i).getPoints().size())
                            .forEach(j -> {
                                if (i != Line.ZERO) {
                                    if (lines.get(i).getPoints().get(j) == Symbol.NONE
                                            && lines.get(i-1).getPoints().get(j) == Symbol.NONE) {
                                        lines.get(i).getPoints().remove(j);
                                        lines.get(i).getPoints().add(j, Symbol.BRIDGE);

                                        if (j > 2) {
                                            lines.get(i).getPoints().remove(j-2);
                                            lines.get(i).getPoints().add(j-2, Symbol.NONE);
                                        }
                                        if (j < lines.get(i).getPoints().size()-2) {
                                            lines.get(i).getPoints().remove(j+2);
                                            lines.get(i).getPoints().add(j+2, Symbol.NONE);
                                        }
                                    }
                                }
                            });
                });
    }

    public List<Line> getLines() {
        return lines;
    }
}
