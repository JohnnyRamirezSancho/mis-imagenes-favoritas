import { useAuthStore } from "../../../stores/authStorage";

export default class AuthConnection {
  #baseUrl = "http://localhost:8080";
  #auth = "";
  #answer = false;

  async login(username, password) {
    if(username=="" || password=="") {
      alert("Debe introducir su usuario y contraseña.")
      return this.answer;
    }

    this.#auth = this.encodeB64(username, password);

    const myHeaders = new Headers();
    myHeaders.append("Authorization", `Basic ${this.#auth}`);
    myHeaders.append("Content-Type", "text/plain");

    const response = await fetch(this.#baseUrl + "/api/login", {
      method: 'GET',
      headers: myHeaders,
      credentials: 'include',
      redirect: 'follow',
    });

    if(response.status==401) {
      alert("Por favor, revise su usuario y contraseña.")
      return this.answer;
    }
    if (response) {
      const user = await response.json()
      const store = useAuthStore();
      store.isAuthenticate = true;
      store.roles = user.role;
      store.username = user.username;
      alert("Bienvenido, " + user.username + ".");
      this.answer = true;
      return this.answer;
    } else {
      alert("Ha ocurrido un error.\nPor favor, inténtelo de nuevo pasados unos minutos.");
      return this.answer;
    }
  }

  encodeB64(username, password) {
    const encodeData = window.btoa(`${username}:${password}`);
    return encodeData;
  }
}
