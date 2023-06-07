import { describe, expect, test, it} from "vitest";
import  {mount} from "@vue/test-utils";
import Gallery from "../src/views/Gallery.vue";
import Pagination from '../src/components/Pagination.vue';
import CardGallery from '../src/components/gallery/CardGallery.vue'
import { shallowMount } from '@vue/test-utils';

describe('Testing Gallery view', () =>{
    const wrapper = shallowMount(Gallery);

    test('Check the div exist',() => {
        expect(wrapper.find('div').exists()).toBe(true)
    });

    test('Check the class .galleryCards exist',() => {
        expect(wrapper.find('.galleryCards').exists()).toBe(true)
    });

    test('Check the component CardGallery exist',() => {
        expect(wrapper.findComponent(Pagination).exists()).toBe(true)
    });
})