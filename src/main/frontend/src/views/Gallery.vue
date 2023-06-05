<script setup></script>

<template>
  <main>
    <div class="card">
      <div class="imageCard">
        <figure>
          <img
            src="../assets/img/Carousel/cripta-sagrada-familia-01.jpg"
            alt=""
          />
        </figure>
      </div>
      <div class="textCard">
        <h2>Image 01</h2>
      </div>
    </div>
    <div class="card">
      <div class="imageCard">
        <figure>
          <img
            src="../assets/img/Carousel/cripta-sagrada-familia-02.jpg"
            alt=""
          />
        </figure>
      </div>
      <div class="textCard">
        <h2>Image 01</h2>
      </div>
    </div>
    <div class="card">
      <div class="imageCard">
        <figure>
          <img
            src="../assets/img/Carousel/cripta-sagrada-familia-03.jpg"
            alt=""
          />
        </figure>
      </div>
      <div class="textCard">
        <h2>Image 01</h2>
      </div>
    </div>
    <div class="card">
      <div class="imageCard">
        <figure>
          <img src="../assets/img/Carousel/sagrada-familia-01.jpg" alt="" />
        </figure>
      </div>
      <div class="textCard">
        <h2>Image 01</h2>
      </div>
    </div>
    <div class="card">
      <div class="imageCard">
        <figure>
          <img src="../assets/img/Carousel/sagrada-familia-02.jpg" alt="" />
        </figure>
      </div>
      <div class="textCard">
        <h2>Image 01</h2>
      </div>
    </div>
    <div class="card">
      <div class="imageCard">
        <figure>
          <img src="../assets/img/Carousel/sagrada-familia-03.jpg" alt="" />
        </figure>
      </div>
      <div class="textCard">
        <h2>Image 01</h2>
      </div>
    </div>
  </main>
</template>

<style lang="scss" scoped>
main {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  .card {
    aspect-ratio: 1/1;
    overflow: hidden;
    border-radius: 0;
    border: none;
    .imageCard {
      figure {
        aspect-ratio: 1/1;
        margin: 0;
        img {
          width: 100%;
          height: 100%;
          object-fit: cover;
          transition: all 0.5s;
        }
      }
    }
    .textCard {
      height: 50px;
      background-color: rgba(66, 66, 66, 0.5);
      transition: all 0.5s;
      h2 {
        font-size: 1.25rem;
        line-height: 50px;
        color: white;
        margin: 0;
        padding: 0 20px;
      }
    }
    &:hover {
      img {
        transform: scale(1.2);
      }
      .textCard {
        transform: translateY(-50px);
      }
    }
  }
}

@media (max-width: 1200px) {
  main {
    grid-template-columns: repeat(3, 1fr);
  }
}
@media (max-width: 768px) {
  main {
    grid-template-columns: repeat(2, 1fr);
  }
}
@media (max-width: 576px) {
  main {
    grid-template-columns: 1fr;
  }
}
</style>
