<script setup>
const props = defineProps({
  item: { type: Object },
});

function hideCard(id) {
  const visor = document.getElementById(id);
  visor.classList.add("invisible");
}
</script>

<template>
  <div class="invisible popup" :id="`${item.id}`">
    <div class="cardDetails">
      <figure>
        <img :src="`http://localhost:8080/${item.imageGallery.image}`" />
      </figure>
      <div class="closeVisor">
        <img
          src="../../assets/img/closed-icon.png"
          alt="Close image"
          @click="hideCard(`${item.id}`)"
        />
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '../../assets/sass/gallery/popupcardgallery.scss';
</style>
