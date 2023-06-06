import GalleryRepository from "./misImagenesFavoritas/GalleryRepository";

export default class ApiRepository {

    api;

    constructor(apiToCharge) {
        this.api = apiToCharge
        this.chooseApi()
    }

    chooseApi() {
        if(this.api === "gallery") return new GalleryRepository;
    }
}