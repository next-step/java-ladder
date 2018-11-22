package generator;

import model.Line;
import model.Participant;
import model.Positive;

import java.util.ArrayList;
import java.util.List;

public interface LadderGenerator {
    public List<Line> getLines(Positive height, int countOfPerson);
}
