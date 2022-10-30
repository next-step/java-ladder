# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


# step2 요구사항
## 기능 요구사항
* 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
* 사람 이름은 쉼표(,)를 기준으로 구분한다.
* 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
* 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
* |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.


## Todo
- [x] 참여자의 이름을 입력받는다.
- [ ] 최대 사다리의 높이를 입력받는다.
- [ ] 실행 결과를 출력한다.

## 실행결과
```
참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
pobi,honux,crong,jk

최대 사다리 높이는 몇 개인가요?
5

실행결과

pobi  honux crong   jk
   |-----|     |-----|
   |     |-----|     |
   |-----|     |     |
   |     |-----|     |
   |-----|     |-----|
```


~~# step1 요구사항~~
## 람다(lambda) 실습
### 1 - 익명 클래스를 람다로 전환
- [x] 테스트 코드에서 MoveStrategy에 대한 익명 클래스로 구현하고 있는데 람다를 적용해 구현한다.

### 2 - 람다를 활용해 중복 제거
- [x] 람다를 활용해 중복을 제거한다.
- [x] nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거한다.

## stream method 실습
### map, reduce, filter 실습 1
-[x] List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다. 지금까지 학습한 map, reduce, filter를 활용해 구현해야 한다.
-[x] nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.

### map, reduce, filter 실습 2 : nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현한다.
-[x] 단어의 길이가 12자를 초과하는 단어를 추출한다.
-[x] 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
-[x] 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출해야 한다.
-[x] 추출한 100개의 단어를 출력한다. 모든 단어는 소문자로 출력해야 한다.


## Optional
### 요구사항 1 - Optional을 활용해 조건에 따른 반환
- [x] ageIsInRange1() 같은 기능을 Optional을 활용해 ageIsInRange2() 메소드에 구현한다. 
- [x] 메소드 인자로 받은 User를 Optional로 생성하면 stream의 map, filter와 같은 메소드를 사용하는 것이 가능하다.
- [x] nextstep.optional.UserTest의 테스트가 모두 pass해야 한다.

### 요구사항 2 - Optional에서 값을 반환
- [x] nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현한다.
- [x] 자바 8의 stream과 Optional을 사용하도록 리팩토링한 후 UsersTest의 단위 테스트가 통과해야 한다.

### 요구사항 3 - Optional에서 exception 처리
- [x] nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다.  단, of 메소드를 구현할 때 자바 8의 stream을 기반으로 구현한다.