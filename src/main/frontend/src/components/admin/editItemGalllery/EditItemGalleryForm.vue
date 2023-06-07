<script setup>
import router from "../../../router/index";
import { computed } from "@vue/reactivity";
import { itemsGallery } from "../../../stores/itemsGallery";

const itemsGalleryToModify = itemsGallery();
const itemsGalleryData = computed(() => {
  return itemsGalleryToModify.itemsGalleryObject;
});

let itemsGalleryEdit = {
  title: itemsGalleryToModify.itemsGalleryObject.title,
};

async function updateItem(id) {
  if (itemsGalleryEdit.title === "") {
    alert("Se necesita añadir un título.");
    return;
  }

  const payload = JSON.stringify(itemsGalleryEdit);
  const url = `http://localhost:8080/api/itemsgallery/${id}`;
  console.log(id);
  const response = fetch(url, {
    method: "PUT",
    body: payload,
    headers: {
      "Content-type": "application/json",
      Accept: "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      if (data.title) {
        itemsGalleryToModify.itemsGalleryObject = itemsGalleryEdit;
        alert("Item " + itemsGalleryEdit.title + " actualizado correctamente.");
      } else {
        alert("Se ha producido un error. \nPor favor, inténtalo más tarde.");
      }
    });
}
</script>

<template>
  <form>
    <h1>Edita item {{ itemsGalleryData.title }}</h1>
    <label for="title" class="form-label">Título:</label>
    <input
      v-model="itemsGalleryData.title"
      id="title"
      class="form-control"
      type="text"
      placeholder="Título"
    />
    <div class="buttons">
      <button type="button" id="btn-delete" class="btn btn">Borrar</button>
      <button
        type="button"
        id="btn-send"
        class="btn btn"
        @click.prevent="updateItem(itemsGalleryData.id)"
      >
        Enviar
      </button>
    </div>
  </form>
</template>

<style lang="scss" scoped>
@import "../../../assets/sass/variables";

form {
  width: 60%;
  padding: 50px;
  background-color: rgba(255, 255, 255, 0.75);
  display: flex;
  flex-direction: column;
  justify-content: space-around;

  h1 {
    text-align: center;
    color: $red;
    font-weight: bold;
  }

  label {
    color: $green;
    font-weight: bold;
    font-size: 2vh;
  }
  input {
    margin-bottom: 25px;
  }

  .buttons {
    display: flex;
    justify-content: center;
    gap: 25px;
    button {
      width: 20vw;
      color: white;
      font-size: 2vh;
    }

    #btn-delete {
      background-color: $red;
      &:hover {
        color: $red;
        background-color: white;
      }
    }

    #btn-send {
      background-color: $green;
      &:hover {
        color: $green;
        background-color: white;
      }
    }
  }
}

@media (max-width: 768px) {
  form {
    width: 100%;
    padding: 20px;

    .buttons {
      flex-direction: column;
      button {
        width: 100%;
      }
    }
  }
}

@media (max-width: 576px) {
  main {
    height: auto;
    form {
      padding-bottom: 60px;
    }
  }
}
</style>
