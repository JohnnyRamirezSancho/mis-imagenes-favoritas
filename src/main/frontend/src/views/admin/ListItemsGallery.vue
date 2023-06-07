<script setup>
import CardItemGallery from '../../components/admin/listitemsgallery/CardItemGallery.vue';
import { onBeforeMount, ref, computed } from "vue";
import ApiRepository from "../../assets/ApiRepository/ApiRepository.js";
import Pagination from "../../components/Pagination.vue";
import router from "../../router/index";
import { itemsGallery } from "../../stores/itemsGallery";
import { imagesGallery } from "../../stores/imagesGallery";

const repository = new ApiRepository("itemsGallery");
const api = repository.chooseApi();

const itemGalleryItem = itemsGallery();
const imageGalleryItem = imagesGallery();

function updateItem(id, itemGallery, imageGallery) {
  itemGalleryItem.itemGalleryObject = itemGallery;
  imageGalleryItem.imageGalleryObject = imageGallery;
  router.push("/updateitemgallery" + "/" + id);
}

function updateImage(id, itemGallery, imageGallery) {
  itemGalleryItem.itemGalleryObject = itemGallery;
  imageGalleryItem.imageGalleryObject = imageGallery;
  router.push("/updateimagegallery" + "/" + id);
}

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

async function deleteItem(id) {
  const response = fetch(`http://localhost:8080/api/itemsgallery/${id}`, {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
  }).then((response) => {
    if (response.status == 200) {
      alert("Item borrado correctamente.");
    } else {
      alert(
        "Se ha producido un error. \nPor favor, inténtelo de nuevo en unos minutos."
      );
    }
  });
}

</script>

<template>
  <main>
    <div class="galleryCards">
      <CardItemGallery
        v-for="itemGallery in itemsGalleryToShow"
        :key="itemGallery.id"
        :item="itemGallery"
      ></CardItemGallery>
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
@import "../../assets/sass/admin/listitemgallery/listitemsgallery.scss";
</style>
