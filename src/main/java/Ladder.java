import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {
    private int height;
    private List<Line> lines = new ArrayList<>();
    private Person persons ;

    public Ladder(Person persons, int height){
        this.height = height;
        this.persons = persons;
        for(int i=0;i<this.height;i++){
            Line line = new Line(persons.getCount());
            line.initLine();
            lines.add(line);
        }
    }

    @Override
    public String toString() {
        StringBuilder ladder = new StringBuilder();
        ladder.append(persons.toString()+"\n");
        for(int i=0;i<this.height;i++){
            ladder.append(lines.get(i).toString()+"\n");
        }
        return ladder.toString();
    }
}
