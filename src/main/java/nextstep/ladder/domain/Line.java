package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Link> links;

    public Line(boolean... links) {
        this.links = IntStream.range(0, links.length)
                .mapToObj(i -> new Link(links[i]))
                .collect(Collectors.toList());
    }

    private Line(List<Link> links) {
        this.links = links;
    }

    public static List<Line> createLines(int countOfLine, int countOfLink) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, countOfLine)
                .forEach(number -> lines.add(createLine(countOfLink)));

        return lines;
    }

    private static Line createLine(int countOfPoint) {
        List<Link> links = new ArrayList<>(List.of(new Link()));
        IntStream.range(1, countOfPoint)
                .forEach(number -> {
                    Link currentLink = links.get(links.size() - 1);
                    links.add(currentLink.createNextLink());
                });

        return new Line(links);
    }

    public boolean hasCountOfLink(int count) {
        return links.size() == count;
    }

    public List<Link> getLinks() {
        return new ArrayList<>(links);
    }

    public List<Integer> move(List<Integer> points) {
        List<Integer> copiedPoints = new ArrayList<>(points);

        IntStream.range(0, links.size())
                .forEach(i -> {
                    if (links.get(i)
                            .isExist()) {
                        int temp = copiedPoints.get(i);
                        copiedPoints.set(i, copiedPoints.get(i + 1));
                        copiedPoints.set(i + 1, temp);
                    }
                });

        return copiedPoints;
    }
}
