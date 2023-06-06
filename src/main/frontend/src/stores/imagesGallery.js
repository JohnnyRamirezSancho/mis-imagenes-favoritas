import { defineStore } from 'pinia'
import { ref } from 'vue';

export const imagesGallery = defineStore ('imagesGallery', () => {
	const imagesGalleryObject = ref([]);
	return imagesGalleryObject
})