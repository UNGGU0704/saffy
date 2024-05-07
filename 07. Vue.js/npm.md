# npm

> *Node.js의 기본 패키지 관리자*
> 

### Node.js란?

- 기존의 JS는 HTML 내부에서만 동작 가능했다…
- Node.js를 활용해 HTML 코드에서 escape!
- 외부에서 만들어진 JS코드를 활용해서 프레임워크 처럼 활용할 수 있다.

**이걸 관리하는 친구가 npm, yarn**

### Node.js의 영향

[네트워크 보안](https://www.notion.so/1521f1291a654347bf52039023f684b1?pvs=21)

- 기존 브라우저 안에서만 동작 가능한 JS를 서버측에서 실행 가능
    - 프론트와 백엔드의 동일한 언어로 개발
- NPM을 활용해 오픈소스로 JS를 사용가능 → **Module**

## Module

- 하나의 JS를 모듈화하여 사용 하는 방식
- 모듈의 수가 늘어감에 따라 의존성이 복잡해진다.
    - 이걸 관리하기 위한 **Bundler**

## Bundler

- 여러 모듈과 파일을 하나의 번들로 묶어 사용시켜주는 도구
- Vite는 RollUp이라는 번들러를 사용해 설정함

```
<template>
<header class="navbar navbar-fixed-top navbar-inverse bg-success text-lg-start">
  <div class="container d-flex justify-content-center">
    <div class="row justify-content-center">
      <div class="navbar-header">
        <a class="navbar-brand" href="#" style="font-size: 3rem;">My Gallery</a>
      </div>
    </div>
  </div>
</header>

<main>
    <br>
    <br>
  <div class="container">
    <div class="row">
      <div class="col-12 col-sm-6 col-md-4 mb-3" v-for="n in numberOfItems" :key="n"> <!-- mb-3 클래스 추가 -->
        <div class="card">
          <img src="@/assets/sample.png" class="card-img-top" alt="Sample Image">
          <div class="card-body">
            <h5 class="card-title">Card {{ n }}</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn btn-primary">Go somewhere</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</main>

  </template>
  
  <script setup>
   const numberOfItems = 4;
  </script>
  
  <style scoped>
  
  </style>
  
    이 코드를 4개의 컴포넌트로 나누기 
  
  1. Header 컴포넌트 
	  - 기존의 Header 부분을 나눠
  2. GalleryList 컴포넌트 
	  - 기존 컴포넌트의 main 요소를 나누기 
	  - card의 반응형 레아아웃을 담당해 
  3. GalleryListItem 컴포넌트 
	  - GalleryList의 하위 컴포넌트
	  - Card 부분을 담당해 
  4. GalleryListItemButton 컴포넌트 
	  - GalleryListIem의 하위 컴포넌트 
	  - Bootstrap Card의 버튼을 담당해 
	  
  각 4개의 파일을 만들어줘 
```