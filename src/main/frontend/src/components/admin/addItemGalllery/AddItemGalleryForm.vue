<script setup>
import { itemsGallery } from "../../../stores/itemsGallery";
import router from "../../../router/index";

const itemGalleryToAdd = itemsGallery();

let itemGalleryAdd = {
  title: "",
};

async function saveItem() {
  if (itemGalleryAdd.title === "") {
    alert("Se necesita añadir un título.");
    return;
  }

  const payload = JSON.stringify(itemGalleryAdd);
  const url = "http://localhost:8080/api/itemsgallery";
  const response = fetch(url, {
    method: "POST",
    body: payload,
    headers: {
      "Content-type": "application/json",
      Accept: "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      if (data.title) {
        itemGalleryToAdd.itemsgalleryObject = data;
        alert("Item " + data.title + " añadido correctamente.");
        router.push("/imagegallery/" + data.id);
      } else {
        alert(
          "Se ha producido un error. \nPor favor, inténtelo de nuevo en unos minutos."
        );
      }
    });
}
</script>

<template>
  <form>
    <h1>Añade un nuevo item a la galería</h1>
    <label for="title" class="form-label">Título:</label>
    <input
      v-model="itemGalleryAdd.title"
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
        @click.prevent="saveItem()"
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
