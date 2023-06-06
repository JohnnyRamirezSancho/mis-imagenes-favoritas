<script setup>
import PopUpCardGallery from './PopUpCardGallery.vue';

const props = defineProps({
  item: { type: Object },
});

function showCard(id) {
  const visor = document.getElementById(id)
  console.log(id);
  visor.classList.remove('invisible')
}

</script>

<template>
  <div class="cardGallery">
    <div class="imageCardGallery">
      <figure>
        <img
        :src="`${item.imageGallery.image}`"
        :alt="`${item.title}`"
        />
      </figure>
    </div>
    <div class="openVisor">
      <img src="../../assets/img/magnifying-glass-icono.png" alt="Open image" @click="showCard(`${item.id}`)">
    </div>
    <div class="textCardGallery">
      <h2>{{ item.title }}</h2>
    </div>
  </div>
  <PopUpCardGallery :item="item"></PopUpCardGallery>
</template>

<style lang="scss" scoped>
@import "../../assets/sass/gallery/cardgallery.scss";
</style>
