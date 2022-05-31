package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Row {
    private final List<Link> links;

    public Row(List<Link> links) {
        this.links = links;
    }

    public int move(int from) {
        return links.get(from).move();
    }

    public static Row createRandom(int length) {
        List<Link> links = Stream.iterate(Link.firstRandom(), link -> link.nextRandom())
                .limit(length - 1)
                .collect(Collectors.toList());
        links.add(links.get(length - 2).last());
        return new Row(links);
    }

    public int size() {
        return this.links.size();
    }


//    public static final Random RANDOM = new Random();
//    private final List<Boolean> points;
//
//    public Row(List<Boolean> points) {
//        this.points = validate(points);
//    }
//
//    static Row create(int countOfPerson) {
//
//        return Stream.concat(
//                        Stream.iterate(RANDOM.nextBoolean(), b -> next(b)).limit(countOfPerson - 1),
//                        Stream.of(false))
//                .collect(Collectors.collectingAndThen(Collectors.toList(), Row::new));
//    }
//
//    static boolean next(Boolean b) {
//        return b ? false : RANDOM.nextBoolean();
//    }
//
//    public List<Boolean> points() {
//        return Collections.unmodifiableList(this.points);
//    }
//
//    public static List<Boolean> validate(List<Boolean> points) {
//        if (Stream.iterate(1, i -> i < points.size(), i -> i + i)
//                .anyMatch(i -> points.get(i - 1) && points.get(i))) {
//            throw new RuntimeException("Consecutive row cannot exist.");
//        }
//        return points;
//    }
}
