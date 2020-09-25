# 사다리 게임
## Step2
> 사다리 생성
### 요구 사항
#### 핵심 로직
- [ ] `Player` 클래스를 정의하여 참여자 책임을 부여한다.
  - [x] 이름 속성을 갖는다. 이름은 최대 5글자까지 부여할 수 있다.
  - [ ] `Player`와 다른 객체와의 협력 관계?
  
- [x] `Point` 클래스를 정의하여 연결 여부를 표현한다.
  - [x] 불변 클래스, VO이므로 재사용하도록 구현한다.
  
- [x] `Line` 클래스를 정의하여 가로 라인 하나를 표현한다.
  - [x] `List<Point>`을 속성으로 갖는다.
  - [x] `List<Point>`에 `true` 값을 가진 `Point`가 연속해서 존재할 수 없다. (유효성 검사)

- [x] `Ladder` 클래스를 정의하여 가로 라인(`Line`)의 집합체를 표현한다.
  - [x] `List<Line>`를 속성으로 갖는다.
  - [x] `List<Line>`의 요소 개수는 입력받은 `height`와 동일하다. (유효성 검사)
  - [x] 각`Line`의 `Point` 개수가 모두 `countOfPerson - 1`로 동일해야 한다. (유효성 검사)
  
- [x] `LadderFactory` 클래스를 정의하여 `Ladder`을 생성하는 책임을 부여한다.
  - [x] `PointsFactory`를 이용하여 높이(`height`) 개수만큼 `Line`을 생성한다.
  
- [x] `PointGenerator` 인터페이스를 정의하여 `true` 혹은 `false` 값을 가지고 있는 `Point` 객체를 반환하는 구현체들을 활용한다.
  - [x] `RandomPointGenerator` 구현체를 이용하여 랜덤으로 `boolean`을 생성한다. (프로덕션용)

- [x] `PointsFactory` 클래스를 정의하여 `List<Point>` 생성 로직을 담당한다.
  - [x] `List<Point>`를 반환하는 메소드를 정의한다.
  - [x] 인자로 전달받은 `List<Point>`에 새로운 `Point`를 추가하는 메소드 구현한다. (연속적으로 `true` 값을 가진 `Point`가 존재하면 안된다.)
 
#### 입출력
- [x] 입력을 처리하는 `InputView` 클래스를 정의한다.
  - [X] 참여자 이름을 입력 받는다.
    - [x] `,` 를 기준으로 구분한다.
  - [x] 최대 사다리 높이를 입력받는다.
  
- [x] 출력을 처리하는 `ResultView` 클래스를 정의한다.
  - [x] 실행 결과를 출력한다.
    - [x] 각 라인에 할당된 이름을 먼저 출력한다.
    - [x] `Ladder` 모양을 출력한다.

#### 피드백
- [x] `List<Line>`을 감싸는 일급 컬렉션 `Lines` 클래스를 정의한다.
  - [x] 기존 `Ladder`에서 수행하는 유효성 검사를 `Lines`에서 처리한다.
- [ ] `Ladder`의 getter를 대체한다?
