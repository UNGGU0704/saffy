# Java - Design Pattern

# MVC Pattern

### Mode

- Domain Class (DTO)

Service Class (비즈니스 로직)

- Data Access Object (DAO)

### View

- Presentation Logic
- UI : GUI, CLI

### Controller

- 사용자의 요청 ~ 응답을 제어 담당

## Package

- Class 들을 분리해서 작업
- 선언 위치 : 소스 코드 파일의 첫번째 수행문
- 선언 회수 : 0, 1
- 선언하지 않으면 : default package (same dir)
- 선언 형식 package top.sub;
    - 깊이는 3~4 정도로 하는게 좋다.
- 공개용 : domain reverse
    - `[ssafy.com](http://ssafy.com)` → `package com.ssafy.model`
- **MVC** 기반의 package 구조
    - `com.ssafy.model`
    - `com.ssafy.model.dto`
    - `com.ssafy.model.service`
    - `com.ssafy.view`
    - `com.ssafy.controller`

## Singleton 패턴

### 객체의 생성을 제한해야한다면?

- 여러개의 객체가 필요하지 않은 경우
    - 수정가능 멤버 변수가 없고 기능만 있는 경우
    - 이런걸 **stateless** 한 객체라고 한다.
    - 객체를 생성/삭제 하는것이 아닌 재사용이 유리한 경우

### Singleton 디자인 패턴

- 외부에서 생성자 접근 금지 → 생성자의 제한자를 private
- 내부에서 직접 객체 생성 → 멤버 변수이므로 private 설정
- 외부에서 접근은 허용한다. → **only getter**
- getter 변수에 static