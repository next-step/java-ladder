package step2.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestLineMakeStrategy implements MakeLineStrategy{
    private boolean marked;

    @Override
    public List<Boolean> create(int countOfPerson) {
        return createByCriteria(countOfPerson);
    }

    private List<Boolean> createByCriteria(int countOfPerson) {
        return IntStream.range(0, countOfPerson - 1)
                .mapToObj((index)->marked)
                .collect(Collectors.toList());

    }
}
