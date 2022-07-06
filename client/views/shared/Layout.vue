<template>
  <section class="bg-gray-200 p-6">
    <header class="flex bg-gray-200 justify-between">
      <div class="flex">
        <h1 class="font-bold text-lg">Retia</h1>
      </div>
      <Nav />
    </header>
  </section>

  <section class="p-6">
    <div class="max-w-3xl mx-auto">
      <slot />
    </div>
  </section>
</template>

<script setup>
import Nav from "./Nav.vue";
</script>