package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Step;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderApplication {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("a", "b", "c", "d", "e");
        List<Person> collect = names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
        Ladder ladder = Ladder.of(collect, 5);

        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            System.out.print(line.getPerson().getName());
            System.out.print("    ");
        }
        System.out.println();
        for(int i = 0; i < 5; i ++) {
            for (Line line : lines) {
                List<Step> steps = line.getSteps().getSteps();
                System.out.print("|");
                if (steps.get(i).isMoveNextLine()) {
                    System.out.print("-----");
                } else {
                    System.out.print("     ");
                }
            }
            System.out.println();
        }

    }
}
