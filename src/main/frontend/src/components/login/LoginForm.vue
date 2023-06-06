<script setup>
import { useAuthStore } from "../../stores/authStorage";
import AuthService from "../../assets/ApiRepository/authentication/authService";
import router from "../../router/index";

let userName = "";
let password = "";
const store = useAuthStore();

const login = async () => {
  const authService = new AuthService();
  const response = await authService.login(userName, password);
  if (response) {
    router.push("/");
  }
};
</script>

<template>
  <form>
    <h1>Login</h1>
    <label for="exampleInputEmail1">Usuario:</label>
    <input
      type="email"
      v-model="userName"
      class="form-control"
      id="email"
      aria-describedby="emailHelp"
    />
    <label for="exampleInputPassword1">Contraseña:</label>
    <input
      v-model="password"
      type="password"
      class="form-control"
      id="password"
    />
    <div class="buttons">
      <button type="button" id="btn-delete" class="btn btn">Borrar</button>
      <button type="button" id="btn-send" class="btn btn" @click="login">
        Enviar
      </button>
    </div>
  </form>
</template>

<style lang="scss" scoped>
@import '../../assets/sass/login/loginform.scss'
</style>
