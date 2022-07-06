import {defineConfig} from "vite";
import vue from "@vitejs/plugin-vue"

export default defineConfig({
    root: './client',
    build: {
        manifest: true,
        outDir: '../resources/',
        emptyOutDir: true
    },
    plugins: [
        vue()
    ]
});
