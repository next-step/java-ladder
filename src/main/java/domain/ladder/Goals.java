package domain.ladder;

import util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Goals {
    private List<String> goals;

    public Goals(String results) {
        String[] goals = StringUtils.toStringArrays(results);
        this.goals = new ArrayList<>();

        for (String goal : goals) {
            this.goals.add(goal);
        }
    }

    public String result(int position) {
        return this.goals.get(position);
    }

    public List<String> getGoals() {
        return goals;
    }

    public String findGoal(int position) {
        return goals.get(position);
    }
}
