<template>
    <div>
        <tour-map></tour-map>
    </div>
</template>

<script>
import TourMap from "@/components/tour/TourMap.vue";

export default {
    name: 'AppTour',
    components: {TourMap},
    data() {
        return {
            message: '',
        };
    },
    created() {},
    methods: {},
};
</script>

<style scoped></style>