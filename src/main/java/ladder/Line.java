package ladder;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final boolean FIRST_POINT = false;

    private List<Boolean> points = new ArrayList<>();
    
    public Line (int countOfPerson) {

        points.add(FIRST_POINT);

        boolean before = false;
        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean recent = isBeforeTrue(before, randomBooleanMaker());
            before = recent;
            points.add(recent);
        }
    }

    private boolean randomBooleanMaker() {
        return new Random().nextBoolean();
    }

    private boolean isBeforeTrue(boolean before, boolean random) {
        return before ? false : random;
    }

    public void showPoint() {
        points.stream().forEach(i -> System.out.print(i ? "-----|" : "     |"));
    }
}
