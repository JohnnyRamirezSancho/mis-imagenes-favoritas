import { defineStore } from 'pinia'
import { ref } from 'vue';

export const itemsGallery = defineStore ('itemsGallery', () => {
	const itemsGalleryObject = ref([]);
	return itemsGalleryObject
})