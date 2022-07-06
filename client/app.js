import {createApp, h} from "vue";
import {createInertiaApp} from "@inertiajs/inertia-vue3";
import {InertiaProgress} from "@inertiajs/progress";

function importPageComponent(name, pages) {
    for (const path in pages) {
        if (path.toLowerCase().endsWith(`${name.replaceAll(".", "/")}.vue`)) {
            return typeof pages[path] === "function" ? pages[path]() : pages[path];
        }
    }

    throw new Error(`Page not found: ${name}`);
}

createInertiaApp({
    resolve: (name) =>
        importPageComponent(name, import.meta.glob("./views/**/*.vue")),
    setup({el, App, props, plugin}) {
        createApp({render: () => h(App, props)})
            .use(plugin)
            .mount(el);
    },
});

InertiaProgress.init({
    showSpinner: true
})