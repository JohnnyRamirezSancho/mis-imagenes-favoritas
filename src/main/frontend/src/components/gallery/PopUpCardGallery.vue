<script setup>
function hideCard(id) {
  const visor = document.getElementById(id);
  visor.classList.add("invisible");
}
</script>

<template>
  <div class="invisible popup" id="patata">
    <div class="cardDetails">
      <button @click="hideCard('patata')">X</button>
      <figure>
        <img
          src="../../assets/img/Carousel/cripta-sagrada-familia-01.jpg"
          alt=""
        />
      </figure>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import "../../assets/sass/variables";
.popup {
  width: 100vw;
  height: 100vh;
  background-color: $darkGreyTrans;
  position: absolute;
  top: 0px;
  left: 0px;
  z-index: 10000;
  position: fixed;
  display: flex;
  align-items: center;
  justify-content: center;

  .cardDetails {
    background: white;
    padding: 10px;
    margin: auto;
    position: relative;
  }

  button {
    position: absolute;
    top: 20px;
    right: 20px;
    display: inline-block;
    padding: 5px 10px;
    border-radius: 10px;
    color: white;
    background-color: $darkGrey;
    border: 3px solid $darkGrey;
    font-weight: bold;
    transition: all 0.3s;
    &:hover {
      background-color: #fff;
      color: $darkGrey;
    }
  }
  .invisible {
    display: none;
  }

  figure {
    margin: 0;
    img {
      object-fit: scale-down;
      max-height: 85vh;
      margin: auto;
    }
  }
}
</style>
