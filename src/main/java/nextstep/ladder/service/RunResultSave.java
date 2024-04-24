package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class RunResultSave {

    public void runResult(Ladder ladder, Person persons, LadderResult results, String want) {
        List<Integer> runResult = new ArrayList<>();
        List<Line> ladders = ladder.getLadder();

        int index = persons.location(want);

        System.out.println("\n실행 결과");
        int max_location = persons.size() - 1;

        for (int i = 0; i < persons.size(); i++) {
            int location = i;
            for (int j = 0; j < ladders.size(); j++) {
                if (ladders.get(j).getList().get(location))
                    location--;
                else if (location < max_location && ladders.get(j).getList().get(location + 1).booleanValue())
                    location++;
            }
            runResult.add(location);
        }

        System.out.println(results.get(runResult.get(index)) + '\n');
        
        for (int i = 0; i < runResult.size(); i++) {
            System.out.println(persons.get(i) + " : " + results.get(runResult.get(i)));
        }
    }
}
