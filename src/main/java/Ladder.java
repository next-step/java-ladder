import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines = new ArrayList<>();
    private Person persons;

    public Ladder(Person persons, int height){
            this.persons = persons;

        for(int i=0;i<height;i++){
            Line line = new Line(persons.personCounts());
            line.initLine();
            lines.add(line);
        }
    }

    @Override
    public String toString() {
        StringBuilder ladder = new StringBuilder();
        ladder.append(persons.toString()+"\n");
        for(int i=0;i<lines.size();i++){
            ladder.append(lines.get(i).toString()+"\n");
        }
        return ladder.toString();
    }
}