# Vue.js란?

### Client-side frameworks

> _클라이언트 측에서 UI와 상호작용을 개발하기 위해 사용되는 JS 기반 프레임워크_

![Untitled](img/vueimg/Untitled.png)

- 일반적으로 웹에서 하는 일이 많아짐
  - 음악 스트리밍
  - 채팅
- 이러한 복잡한 대화식 웹 사이트를 **웹 어플리케이션**이라고 부름
- 일반적인 바닐라 JS코드로는 너무 복잡해짐

### Single Page Application

- 페이지 한개로 구성된 웹 어플리케이션
- 초기 로딩 후 새로운 페이지 요청 없이 동적 화면 갱신

### Client-side Redering

- 클라이언트에서 화면을 렌더링
- 속도가 빠르다.
- 새로고침 없이 진행
- Front와 Back의 명확한 분리
- 초기 구동속도의 느림
- SEO 문제
  - 페이지 추후 렌더링이기에 검색 노출도 감소

## Vue

- 사용자 인터페이스 구축을 위한 JS 프레임워크
- 쉬운 난이도, 반응성 시스템, 유연한 구조
- 선언적 렌더링
- 반응형

```jsx
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Vuejs</title>
    <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
  </head>
  <body>
    <div id="app"></div>
    <script>
      const { createApp, ref } = Vue;

      const app = createApp({
        setup() {
          return {};
        },
      });

      app.mount("#app");
    </script>
  </body>
</html>

```

![Untitled](img/vueimg/Untitled%201.png)

### 결과

![Untitled](img/vueimg/Untitled%202.png)

## Vue 작성하기

### 어플리케이션 instance 작성

![Untitled](img/vueimg/Untitled%203.png)

- 모든 Vue 어플리케이션은 createApp 함수로 시작한다.

### app.mount()

![Untitled](img/vueimg/Untitled%204.png)

- 컨테이너 요소에 인스턴스를 탑재
- 각 인스턴스에 mount()는 한번만 호출 가능

### ref()

> 반응형 상태를 선언하는 함수

- 인자를 받아 .value 속성이 있는 ref 객체로 래핑하여 반환
- ref로 선언된 변수 변경시 값 사용하는 템플릿들도 자동으로 바뀐다.

![Untitled](img/vueimg/Untitled%205.png)

- 템플릿의 참조에 접근하려면 setup() 함수에서의 선언 및 반환이 필요하다.
- 템플렛 내에서는 .value를 작성안해도 됨
