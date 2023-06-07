<script setup>
import PopUpCardGallery from "./PopUpCardItemGallery.vue";

import { itemsGallery } from "../../../stores/itemsGallery";
import { imagesGallery } from "../../../stores/imagesGallery";
import router from "../../../router";

const itemGalleryItem = itemsGallery();
const imageGalleryItem = imagesGallery();

function updateItem(id, itemGallery, imageGallery) {
  itemGalleryItem.itemsGalleryObject = itemGallery;
  imageGalleryItem.imagesGalleryObject = imageGallery;
  router.push("/updateitemgallery" + "/" + id);
}

function updateImage(id, itemGallery, imageGallery) {
  itemGalleryItem.itemGalleryObject = itemGallery;
  imageGalleryItem.imageGalleryObject = imageGallery;
  router.push("/imagegallery" + "/" + id);
}

async function deleteItem(id) {
  if (confirm("¿Seguro que desea borrar este item?")) {
    const response = fetch(`http://localhost:8080/api/itemsgallery/${id}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    }).then((response) => {
      if (response.status == 200) {
        alert("Item borrado correctamente.");
        location.reload();
      } else {
        alert(
          "Se ha producido un error. \nPor favor, inténtelo de nuevo en unos minutos."
        );
      }
    });
  }
}
const props = defineProps({
  item: { type: Object },
});

function showCard(id) {
  const visor = document.getElementById(id);
  visor.classList.remove("invisible");
}
</script>

<template>
  <div class="cardGallery">
    <div class="imageCardGallery">
      <figure>
        <img
          :src="`http://localhost:8080/${item.imageGallery.image}`"
          :alt="`${item.title}`"
          v-if="item.imageGallery"
        />
      </figure>
    </div>
    <div class="openVisor">
      <img
        src="../../../assets/img/magnifying-glass-icono.png"
        alt="Open image"
        @click="showCard(`${item.id}`)"
      />
    </div>
    <div class="textCardGallery">
      <h2>{{ item.title }}</h2>
    </div>
    <div class="buttons">
      <figure class="delete">
        <img
          src="../../../assets/img/trash.png"
          alt="Delete"
          @click="deleteItem(item.id)"
        />
      </figure>
      <figure class="edit">
        <img src="../../../assets/img/edit.png" alt="Edit"  />
      </figure>
      <figure class="image">
        <img src="../../../assets/img/image.png" alt="Image" @click="updateImage(item.id, item, item.imageGallery)" />
      </figure>
    </div>
  </div>
  <PopUpCardGallery :item="item"></PopUpCardGallery>
</template>

<style lang="scss" scoped>
@import "../../../assets/sass/admin/listitemgallery/cardItemgallery.scss";
</style>
