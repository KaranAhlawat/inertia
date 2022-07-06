<template>
  <Link :class="{'font-bold underline': active }" class="text-blue-500 hover:underline">
    <slot />
  </Link>
</template>

<script setup>
import {Link} from "@inertiajs/inertia-vue3";

defineProps({
  active: Boolean,
});
</script>