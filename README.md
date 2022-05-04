# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

### step 1. 자바8 스트림, 람다, Optional
1. 람다 - 익명 클래스를 람다로 변환
2. 람다 - 람다를 활용해 중복 제거
   1. List 에 담긴 값 중 3보다 큰 수만을 더해야 한다.
   2. suAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거!
3. 스트림 - map, reduce, filter 실습 1
   1. List 에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구함
      1. 학습한 map, reduce, filter 를 활용
4. 스트림 - map, reduce, filter 실습 2
   1. nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현
      1. 단어의 길이가 12자를 초과하는 단어 추출
      2. 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어 추출
      3. 단어 중복을 허용하지 않음. -> 서로 다른 단어 100개 추출
      4. 추출한 100개의 단어를 출력. -> 모든 단어는 소문자로 출력
5. Optional
   1. nextstep.optional.User 의 ageIsInRange1() 메서드를 Optional 을 활용해 ageIsInRange2() 메소드로 구현
      1. nextstep.optional.UserTest 의 테스트가 모두 pass 해야 한다.
   2. nextstep.optional.Users 의 getUser() 메서드를 stream 과 Optional 을 활용해 구현
      1. 자바 8 stream 과 Optional 을 사용하도록 리팩토링한 후에 UsersTest 의 단위 테스트 통과
   3. nextstep.optional.ExpressionTest 의 테스트가 통과하다록 Expression 의 of 메서드를 구현
   4. of 메서드를 구현할 때 자바 88의 stream 을 기반으로 구현

### step 2. 사다리(생성)
0. refactoring list
   1. sumAll, sumAllEven, sumAllOverThree 다시 구현하기
   2. @FunctionalInterface 사용하기! (제약)
      1. https://zzang9ha.tistory.com/303
   3. 클래스 내부의 상수 접근제한자 private 으로 수정
   4. 불필요한 import 줄이기
      1. https://milenote.tistory.com/25
   5. findFirst & findAny 의 차이점 인지하기
      1. https://codechacha.com/ko/java8-stream-difference-findany-findfirst/
   6. 정렬 실수 (현재: 작은 순서부터되어 있음, 수정: 긴 순서부터 출력되도록)
   7. map 을 통해 age 를 가져온 후에 필터 처리..!
   8. `ofNullable 자체가 null 에 대해 안정성을 보장하기 때문에 null 검증은 필요하지 않다!`
1. 사람 이름을 쉼표(,)를 기준으로 구분
   1. 사람 이름이 문자열이니깐 클래스로 포장해서 관리해보자
   2. 이름은 최대 5자!
2. 사람 이름 클래스를 가지는 Player 클래스를 관리하자.
3. 가로를 한 라인(Line)으로 한다
   1. Line 을 일급 콜렉션(ex. List<Boolean> points)으로 사용하고
   2. Line 에서 관리하는 일급 콜렉션의 수는 사용자의 수다.
4. 사다리 구현 생각
   1. Line 에서 관리하는 points 리스트는 오른쪽으로 갈 수 있는지 없는지(true, false)에 대해 상태 값을 갖는다.
   2. 순서가 있는 ArrayList 를 사용하여 맨 오른쪽을 제외한(맨 오른쪽에서 오른쪽으로 갈 수 없으니) 나머지 points 는 true/false 를 가질 수 있다.
   3. 맨 오른쪽의 왼쪽인 (idx: n - 2)에서 시작을 하면서 자신의 오른쪽의 값을 확인한다.
   4. 오른쪽 값을 확인하면서 true/false 를 갖도록 나만의 RandomBooleanGenerator 를 구현한다.
   5. 중간에 있는 point 같은 경우는 오른쪽에 있는 point 를 참조해서 true 라면 그냥 pass, false 라면 Random 을 돌린다.
5. 사용자 입력 값인 사다리 높이가 라인(Line)의 개수다.
6. LadderGame 클래스를 사용하여 List<Line> 을 관리하도록 한다.
7. LadderGame 에서 관리하고 있는 List<Line> 을 활용하여 사다리를 출력 할 수 있다.
   1. Line 에 있는 points 리스트는 상태 값에 상관 없이 "|" 를 출력한다.
   2. 만약 points 리스트에 존재하는 point 의 상태 값이 true 라면? "-"을 참여한 사용자의 이름만큼 출력한다.
   3. 이 과정을 LadderGame 의 List<Line> 의 사이즈 즉, 최대 사다리 높이만큼 반복한다.

#### step 2.1 사다리(생성) 1차 피드백
1. 생성자 대신 정적 팩토리 메서드의 장단점을 알고 사용해보자
2. Line 클래스에서 points List 를 객체 생성과 동시에 생성하니깐 불변 형태로 만들어보자
3. Player 가 단순히 PlayerName 의 Wrapper Class 처럼 보인다! 이에 대한 나의 생각
4. 외부에 영향이 없는 불변 객체를 만들어보자
5. 현재 출력을 위해 toString 을 사용하고 있는데, java 에서 toString 은 어떤 용도로 재정의해서 사용해야 될까?
6. getPlayers 또한 방어적 복사를 사용하자
7. String[] strings 의 변수 명이 너무 추상적이다. (의미 있는 변수 명 사용!)
8. System.out.println 은 성능에 좋지 않다! 한번에 처리할 수 있는 방법!
9. "   " -> 공백도 BLANK 라는 상수로 빼내서 사용하자
10. 메서드 참조 시 static 하게 선언하지 않아도 되는 방법
11. 다른 테스트와 같이 모든 테스트 클래스의 접근 지정자 생략
12. 테스트 작성 시 @DisplayName 사용 권장!
13. (참고) Random 클래스에 nextBoolean 을 통해 true, false 를 알 수 있다.
14. -1 도 의미 있는 상수로 빼내보자
15. int i 대신에 이름이 명확한 변수 명을 사용하자
16. 어떤 값이 잘못되었는지 예외 메시지에 함께 넣어주면 원인을 파악하기 더 쉽다

### step 3. 사다리(게임 실행)
0. refactoring list
   1. new ArrayList<>() vs unmodifiableList()
   2. 출력 부분에 일관되게 StringBuilder 사용!
   3. UserName -> PlayerName 파일 명 변경
   4. LineGenerator 를 추상 클래스로 만들어준 이유
1. 사다리 게임을 실행할 수 있다. - 실행 결과를 입력할 수 있다.
2. 개인별 이름을 입력하면 개인별 결과를 출력할 수 있다.
3. "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.
   1. 만약 사다리 게임에 참여한 이름 or "all"을 제외한 input 이 들어오면 Exception
4. Rule: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.

#### step 3.1 사다리(게임 실행) 1차 피드백
1. 패키지 분리 (view, domain, util 등!)
2. Sting[] 보다는 안정성을 보장할 수 있는 List 형태로 사용하자
3. main 의 역할이 너무 크다! 메서드의 단위를 최대한 줄여 볼 수 있는 방법은?
4. 입력과 출력의 요구사항 반영! - 루프를 돌다가  특정 문장에 프로그램이 종료되도록
5. 정적 팩토리 네이밍 컨벤션 일관되게 가져가기
6. (참고 & 생각해보고 반영해보기) Map 의 Key 를 PlayerName 으로! 그리고 출력에서 getter 를 사용하도록 유도
7. Ladders 의 생성자에서 stream 을 사용해보자. (IntStream.rangeClose, IntStream.range)
   1. 둘의 차이점도 같이 학습하면 좋다!
8. Ladders 에서 너무 많은 역할을 담당하고 있다!
   1. Players, Ladders, LaddersResults 세 개로 분리하고, LadderGame 에서 정말 게임하듯이 !
9. LaddersResults 에서도 똑같이 String[] 보다는 List 의 형태로 사용!
10. Line 에서 가지고 있는 List<Boolean> points 도 원시 값 포장을 진행하여 클래스로 도출!
11. Players 에서도 생성을 할 때 String[] 을 사용하고 있는데 stream 을 이용하면 생성과 동시에 List 형태로 초기화 가능!
12. StringBuilder 사용시 무슨 용도의 Builder 인지 변수 네이밍을 바꿔주자
13. ResultView 의 결과 출력 부분에서 System.out 을 builder 형태로 사용해보자!

### step 4. 사다리(리팩토링)
1. 기능은 요구사항 3단계까지 같다.
2. 객체 설계 힌트 참고 하여 철저하게 TDD 로 재구현해 본다.
3. 기존 작성한 코드는 유지하고 새로운 패키지에 작성할 예정
4. Direction 클래스 현재 Point 에서 좌,우로 갈 수 있는지 상태를 가지는 클래스
   1. 좌, 우가 true, true 일 수는 없다.
   2. 처음의 경우 왼쪽 false 고정, 오른쪽은 random 생성
   3. 중간의 경우 왼쪽은 이전 right 의 값으로 설정, 오른쪽은 random 생성
   4. 마지막의 경우 왼쪽은 이전 right 의 값으로 설정, 오른쪽은 false 고정
   5. 다음 Point 의 Direction 을 생성하는 방법
      1. 현재 위치에서 .next(true) 를 통해 다음 위치의 우측 방향을 true 로 설정
      2. 현재 위치에서 .next(false) 를 통해 다음 위치의 우측 방향을 false 로 설정
      3. 여기서 공통적으로 현재 위치의 right 가 true 일 경우 매개변수의 값과 상관없이 false 로 설정, or Exception
      4. 현재 위치에서 매개변수가 없는 .next() 를 호출했을 경우 Random 하게 true, false 를 설정하는 util 클래스 사용
5. Point 클래스 사용 현재의 위치, 방향을 인스턴스 변수로 가짐
   1. Point 에서는 현재 가지고 있는 Direction 의 left, right 값을 통해 좌, 우를 판별함
6. Line 클래스 사용 private final List<Point> points
   1. Line 에서는 현재 위치를 받아서, 해당 위치의 Point 의 left, right 를 확인하고 이동 가능 여부를 알려줌
7. Ladders 클래스 사용 private final List<Line> ladders
   1. Ladders 에서는 현재 위치를 받아서, Line 에서 알려주는 left, right 의 이동 여부를 판별하고 다음 지점으로 이동함
      1. 왼쪽 아래, 오른쪽 아래, 그냥 아래
   2. Ladders 에서 출발 위치에 따른 도착 위치 값을 도출해야 한다.
8. LaddersResults 클래스 사용
   1. Ladders 에서 구한 도착 위치 값을 토대로 사다리 타기의 결과 값을 구함.