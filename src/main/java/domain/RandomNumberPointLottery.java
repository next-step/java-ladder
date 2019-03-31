package domain;

import util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RandomNumberPointLottery implements PointLottery {
    @Override
    public List<Point> draw(List<Point> points) {
        return points.stream()
            .filter(p -> p.getX() + p.getY() > RandomNumberGenerator.nextInt(0, 10))
            .collect(Collectors.toList());
    }
}
