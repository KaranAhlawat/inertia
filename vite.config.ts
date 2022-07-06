import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue"

export default defineConfig(({ command }) => {
  return {
    root: './client',
    build: {
      manifest: true,
      outDir: '../resources/',
      emptyOutDir: true
    },
    plugins: [
      vue()
    ]
  }
});
