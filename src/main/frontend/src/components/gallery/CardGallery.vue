<script setup>
import PopUpCardGallery from './PopUpCardGallery.vue';

function showCard(id) {
  const visor = document.getElementById(id)
  console.log(id);
  visor.classList.remove('invisible')
}

</script>

<template>
  <div class="cardGallery">
    <div class="openVisor">
      <button @click="showCard('patata')" class="buttonHideCard">X</button>
    </div>
    <div class="imageCardGallery">
      <figure>
        <img
          src="../../assets/img/Carousel/cripta-sagrada-familia-01.jpg"
          alt=""
        />
      </figure>
    </div>
    <div class="textCardGallery">
      <h2>Image 01</h2>
    </div>
  </div>
  <PopUpCardGallery></PopUpCardGallery>
</template>

<style lang="scss" scoped>
@import "../../assets/sass/gallery/cardgallery.scss";
</style>
