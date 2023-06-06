<script setup>
import CardGallery from "../components/gallery/CardGallery.vue";
import { onBeforeMount, ref, computed } from "vue";
import ApiRepository from "../assets/ApiRepository/ApiRepository.js";
import Pagination from "../components/Pagination.vue";

const repository = new ApiRepository("itemsGallery");
const api = repository.chooseApi();

const itemsGalleryCardxPage = 12;
const start = ref(0);
const end = computed(() =>
  Math.min(start.value + itemsGalleryCardxPage, itemsGalleryList.value.length)
);

let itemsGalleryList = ref([]);
onBeforeMount(async () => {
  itemsGalleryList.value = await api.getAll();
});

const itemsGalleryToShow = computed(() => {
  return itemsGalleryList.value.slice(start.value, end.value);
});

const next = () => {
  start.value += itemsGalleryCardxPage;
};

const prev = () => {
  start.value = Math.max(start.value - itemsGalleryCardxPage, 0);
};

const page = (algo) => {
  start.value = algo;
};
</script>

<template>
  <main>
    <div class="galleryCards">
      <CardGallery
        v-for="itemGallery in itemsGalleryToShow"
        :key="itemGallery.id"
        :item="itemGallery"
      ></CardGallery>
    </div>
    <Pagination
      :pageSize="itemsGalleryCardxPage"
      :start="start"
      :end="end"
      :maxLength="itemsGalleryList.length"
      @change="page"
      @prev="prev"
      @next="next"
      class="mt-5"
    />
  </main>
</template>

<style lang="scss" scoped>
@import "../assets/sass/gallery/gallery.scss";
</style>
