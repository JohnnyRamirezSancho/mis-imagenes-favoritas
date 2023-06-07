<script setup>
import { computed } from "@vue/reactivity";
import { itemsGallery } from "../../../stores/itemsGallery"
import router from "../../../router/index";

const itemGalleryToModify = itemsGallery();

const itemGalleryData = computed(() => {
  return itemGalleryToModify.itemsGalleryObject;
});

const props = defineProps({
  id: {
    type: String,
  },
});

async function uploadFile(id) {
  let formData = new FormData();
  let url = `http://localhost:8080/api/itemsgallery/${id}/image`;
  formData.append("image", image.files[0]);
  let response = await fetch(url, {
    method: "POST",
    body: formData,
  });

  if (response.status == 200) {
    alert("Imagen subida satisfactoriamente.");
    router.push("/listitemgallery");
  }
  if (response.status == 406) {
    alert(
      "Ya existe una imagen con ese nombre.\nNo puede haber dos que se llamen igual."
    );
  }
  if (response.status != 200 && response.status != 406) {
    alert("Se ha producido un error.\nPor favor, inténtelo más trade.");
  }
}

async function deleteFile(id) {
  if (confirm("¿Está seguro de que quiere borrar esta imagen?") == true) {
    fetch(`http://localhost:8080/api/itemsgallery/${id}/image`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
    });
    alert("Imagen borrada satisfactoriamente.");
    router.push("/listitemgallery");
  }
}
</script>

<template>
  <div class="container">
    <h2>1 {{ itemGalleryData }}</h2>
    <h2>2 {{ itemGalleryToModify }}</h2>
    <div class="row">
      <div class="col-12 mt-4 mb-4">
          <button
            @click="deleteFile(id)"
            type="button"
            class="btn btn-success me-2 w-50 mt-3"
          >
            Eliminar imagen
          </button>
        </div>
        <label for="imagen" class="form-label">Patata</label>
        <input
          type="file"
          id="image"
          class="form-control"
          placeholder="añade foto"
        />
        <button
          @click="uploadFile(id)"
          type="button"
          class="btn btn-success me-2 w-50 mt-3"
        >
          Enviar
        </button>
      </div>
    </div>
</template>

<style lang="scss" scoped>

</style>
