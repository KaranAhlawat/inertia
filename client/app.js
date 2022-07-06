import { createApp, h } from "vue";
import { createInertiaApp } from "@inertiajs/inertia-vue3";
import { InertiaProgress } from "@inertiajs/progress";
import Layout from "./views/shared/Layout.vue";

createInertiaApp({
  resolve: async (name) => {
    let vueName = name[0].toUpperCase() + name.slice(1);

    let page = (await import(`./views/${vueName}.vue`)).default;
    
    page.layout ??= Layout;
    
    return page;
  },
  setup({ el, App, props, plugin }) {
    createApp({ render: () => h(App, props) })
      .use(plugin)
      .mount(el);
  },
});

InertiaProgress.init({
  showSpinner: true,
});
