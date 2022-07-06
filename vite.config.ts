import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue"

export default defineConfig(({ command }) => {
  return {
    root: './resources',
    build: {
      manifest: true,
      outDir: 'public/',
    },
    plugins: [
      vue()
    ]
  }
});
