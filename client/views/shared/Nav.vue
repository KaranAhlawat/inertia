<template>
  <nav>
    <ul class="flex list-disc space-x-4 list-inside">
      <li>
        <NavLink href="/" :active="$page.component === 'home'">Home</NavLink>
      </li>
      <li>
        <NavLink href="/users" :active="$page.component === 'users'">Users</NavLink>
      </li>
      <li>
        <NavLink href="/settings" :active="$page.component === 'settings'">Settings</NavLink>
      </li>
    </ul>
  </nav>
</template>

<script setup>
import NavLink from "./NavLink.vue";
</script>
