# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

--------
## 1단계 - 자바8 스트림, 람다, Optional
- 해당 단계의 경우 문제 풀이 형태로 별도 설계 미진행

--------
## 2단계 - 사다리(생성)
### 0. 요구사항
1. 기능 요구사항
    - 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
    - 사람 이름은 쉼표(,)를 기준으로 구분한다.
    - 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
    - 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
        - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
2. 프로그래밍 요구사항
    - 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
    - 규칙 6: 모든 엔티티를 작게 유지한다.
### 1. Domain
- 이번 단계의 경우 메서드는 생성자 외에 필요하지 않을 것으로 예상.
1. People : People(String peopleString)
   1. 속성
        - List<Person> people
2. Ladder : Ladder(int countOfPeople, int heightOfLadder)
   1. 속성
        - List<Line> ladder
3. Person : Person(String name)
   1. 속성
        - String name
4. Line : Line(int countOfPeople)
    1. 속성
        - List<Boolean> points

--------
## 3단계 - 사다리(게임 실행)
### 0. 요구 사항
1. 기능 요구사항
   - 사다리 실행 결과를 출력해야 한다.
   - 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.
2. 프로그래밍 요구사항
   - 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
      - 규칙 6: 모든 엔티티를 작게 유지한다.
      - 규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
   - 실행 결과
      - 위 요구사항에 따라 4명의 사람을 위한 5개 높이 사다리를 만들 경우, 프로그램을 실행한 결과는 다음과 같다.
   ```
   참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
   pobi,honux,crong,jk
   
   실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
   꽝,5000,꽝,3000
   
   최대 사다리 높이는 몇 개인가요?
   5
   
   사다리 결과
   
     pobi  honux crong   jk
        |-----|     |-----|
        |     |-----|     |
        |-----|     |     |
        |     |-----|     |
        |-----|     |-----|
       꽝  5000     꽝  3000
   
   결과를 보고 싶은 사람은?
   pobi
   
   실행 결과
   꽝
   
   결과를 보고 싶은 사람은?
   all
   
   실행 결과
   pobi : 꽝
   honux : 3000
   crong : 꽝
   jk : 5000
   ```
3. 추가 반영 사항
   - 실행 결과(Result) 글자 수 5 이하 반영
   - 결과 조회 시 person name 오기입 검증 
   
### 1. Domain
1. People : `People(List<String> peopleString)`
   1. 속성
      - `List<Person> people`
2. Ladder : `Ladder(int countOfPeople, int heightOfLadder)`
   1. 속성
      - `List<Line> ladder`
   2. 메서드
      - `WinningResult makeWinningResult(People people, Results results)`
3. Person : `Person(String name)`
   1. 속성
      - `String name`
4. Line : `Line(int countOfPeople)`
   1. 속성
      - `List<Boolean> points`
5. Results : `Results(List<String> resultsString)`
   1. 속성
      - `List<Result> results`
6. Result : `Result(String result)`
   1. 속성
      - `String result`
7. WinningResult : `WinningResult(Map<Person, Result> winningResult)`
   1. 속성
      - `Map<Person, Result> winningResult`
   2. 메서드
      - `Result findBy(Person person)`
      - `Map<Person, Result> findAll()`