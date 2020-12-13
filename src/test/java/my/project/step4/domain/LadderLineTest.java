package my.project.step4.domain;


import org.junit.jupiter.api.Test;

/**
 * Created : 2020-12-11 오전 11:21
 * Developer : Seo
 */
class LadderLineTest {
    @Test
    void init() {
        int sizeOfPerson = 4;
        for (int i = 0; i < 4 ; i++) {
            LadderLine ladderLine = LadderLine.init(sizeOfPerson);
            System.out.println(ladderLine);
        }
    }

    @Test
    void move() {
        LadderLine line = LadderLine.init(4);
        System.out.println(line);
        System.out.println("ladder result : " + line.move(0));
    }
}