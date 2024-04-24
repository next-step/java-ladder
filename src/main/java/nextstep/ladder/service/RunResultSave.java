package nextstep.ladder.service;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class RunResultSave {

    public void runResult(Ladder ladder, List<String> persons, List<String> results, String want) {
        List<Integer> runResult = new ArrayList<>();
        List<Line> ladders = ladder.getLadder();

        int index = 0;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).equals(want)) {
                index = i;
                break;
            }
        }

        System.out.println("실행 결과");
        int max_location = persons.size() - 1;

        for (int i = 0; i < persons.size(); i++) {
            int location = i;
            for (int j = 0; j < ladders.size(); j++) {
                if (ladders.get(j).getList().get(location).booleanValue())
                    location--;
                else if (location < max_location && ladders.get(j).getList().get(location + 1).booleanValue())
                    location++;
            }
            runResult.add(location);
        }

        System.out.println(results.get(runResult.get(index)));
        System.out.println();
        
        for (int i = 0; i < runResult.size(); i++) {
            System.out.println(persons.get(i) + " : " + results.get(runResult.get(i)));
        }
    }
}
