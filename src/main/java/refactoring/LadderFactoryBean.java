package refactoring;

import refactoring.domain.LadderFatory;
import refactoring.domain.LineFactory;
import refactoring.domain.MyLadderFactory;
import refactoring.domain.MyLineFactory;

public class LadderFactoryBean {

    public static LadderFatory createLadderFactory() {
        LineFactory lineFactory = new MyLineFactory();
        return new MyLadderFactory(lineFactory);
    }
}
