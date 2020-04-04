package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.domain.step.Steps;

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

        Lines lines = ladder.getLines();
        for (Line line : lines.getLines()) {
            System.out.print(line.getPerson().getName());
            System.out.print("    ");
        }
        System.out.println();
        for(int i = 0; i < 5; i ++) {
            int j = 0;
            for (Line line : lines.getLines()) {
                Steps steps1 = line.getSteps();
                List<Step> steps = steps1.getSteps();
                System.out.print("|");

                Step step = steps.get(i);
                if (step.isMovable() && step.getBridge().getLinePosition() == j+1) {
                    System.out.print("-----");
                } else {
                    System.out.print("     ");
                }
                j++;
            }
            System.out.println();
        }
        System.out.println();
    }
}
