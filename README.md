# 기능 구현 목록

### 입력
- [ ] 사람의 이름을 입력한다.
  - [ ] 입력한 값을 반환한다.
  - [ ] 쉼표로 사람 이름을 구분한다.
  - [ ] 알파벳이어야 한다.
  - [ ] null, "" 입력은 입력할 수 없다.
  - [x] 최대 5글자까지 부여할 수 있다. (도메인 검증)
- [ ] 최대 사다리 높이를 입력한다.
  - [ ] 입력한 값을 반환한다.
  - [ ] 숫자만 입력해야 한다.
  - [ ] null, "" 입력은 입력할 수 없다.
  - [ ] 두 자릿수 이상에서 첫번째 자리에 0을 입력할 수 없다.
  - [ ] 0 또는 음수는 입력할 수 없다. (도메인 검증)
- [ ] 실행 결과 입력
  - [ ] 입력한 값을 반환한다.
  - [ ] 쉼표로 사람 이름을 구분한다.
  - [ ] null, "" 입력은 입력할 수 없다.
  - [ ] 특수문자 입력 불가
  - [ ] 사람 수와 같은 개수만 입력할 수 있다. (도메인 검증)
- [ ] 결과 보고 싶은 사람 입력
  - [ ] 입력 값 반환
  - [ ] 존재하는 사람 또는 all 만 입력 가능 (도메인 검증)

### 출력
- [ ] 사다리를 출력한다.
  - [ ] 사람 이름을 사다리 위에 같이 출력한다.
  - [ ] 사다리의 폭은 9로 설정한다. (이름이 5자 까지 가능하기에 6 이상이어야 한다.)
- [ ] 실행 결과도 사다리 출력 시 같이 출력
- [ ] 결과 보고 싶은 사람 출력
  - [ ] 해당 사람의 결과 출력
  - [ ] all 입력 시 모든 결과 출력

### 도메인
- [x] 사다리 생성
- [x] 사다리의 라인을 설정한다.
  - [x] 사다리 라인 생성한다.
  - [x] 가로라인이 겹치지 않아야 한다.
  - [x] 가로라인의 맨 처음은 무조건 부분 라인이 없어야 한다.
  - [x] 가로라인의 맨 끝은 무조건 부분 라인이 없어야 한다.
- [x] 해당 위치에서 이동방향 결정
  - [x] 왼쪽
  - [x] 오른쪽
  - [x] 패스
- [x] 한 사람의 한 번의 이동 결과 구하기
- [x] 한 사람의 사다리 높이만큼의 이동 결과 구하기
- [ ] 여러 사람의 최종 이동 결과 구하기