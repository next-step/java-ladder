# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 1단계 - 스트림, 람다, Optional
 - [x] 람다 실습 1 - 익명 클래스를 람다로 전환 
   - MoveStrategy에 대한 익명 클래스로 구현하고 있는데 람다를 적용해 구현한다.
 - [x] 람다 실습 2 - 람다를 활용해 중복 제거 
   - nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거
 - [x] map, reduce, filter 실습 1
   - List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을  학습한 map, reduce, filter를 활용해 구현.
 - [x] map, reduce, filter 실습 2
   - nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현
     - 단어의 길이가 12자를 초과하는 단어를 추출한다. 
     - 중복 단어 제거한다
     - 단어 길이에 따라 내림차순 정렬
     - 상위 100개 단어만 선택
     - 모든 단어를 소문자로 변환
     - 각 단어 출력
 - [x] 요구사항 1 - Optional을 활용해 조건에 따른 반환
   - 나이를 추출
   - 특정 나이 범위 내의 데이터 필터
   - 필터링 후 값이 존재하는지 확인
 - [x] 요구사항 2 - Optional에서 값을 반환
   - 이름이 일치하는 사용자 필터링
   - 첫 번째 일치하는 사용자 찾기
   - 일치하는 사용자가 없으면 DEFAULT_USER 반환
 - [x] 요구사항 3 - Optional에서 exception 처리
   - Arrays.stream()을 이용해 배열을 stream으로 생성
   - 일치하는 값 하나를 추출할 때 findFirst() 메소드를 활용
   - Optional의 orElseThrow() 메소드 활용