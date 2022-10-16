# 사다리 게임

## 진행 방법

* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 람다 실습 1 - 익명 클래스를 람다로 전환

- 다음 테스트 코드에서 MoveStrategy에 대한 익명 클래스로 구현하고 있는데 람다를 적용해 구현한다.

```// nextstep.fp.CarTest의 이동, 정지 method
public class CarTest {
@Test
public void 이동() {
Car car = new Car("pobi", 0);
Car actual = car.move(new MoveStrategy() {
@Override
public boolean isMovable() {
return true;
}
});
assertEquals(new Car("pobi", 1), actual);
}


    @Test
    public void 정지() {
        Car car = new Car("pobi", 0);
        Car actual = car.move(new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        });
        assertEquals(new Car("pobi", 0), actual);
    }
}
```

## 람다 실습 2 - 람다를 활용해 중복 제거

```
// nextstep.fp.Lambda의 sumAll method
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

public int sumAll(List<Integer> numbers) {
int total = 0;
for (int number : numbers) {
total += number;
}
return total;
}
```

```
// nextstep.fp.Lambda의 sumAllEven method
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

public int sumAllEven(List<Integer> numbers) {
int total = 0;
for (int number : numbers) {
if (number % 2 == 0) {
total += number;
}
}
return total;
}
```

List에 담긴 값 중 3보다 큰 수만을 더해야 한다.
이 기능을 구현하려고 보니 앞의 요구사항 1,2와 많은 중복이 발생한다. 람다를 활용해 중복을 제거한다.

// nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거한다.