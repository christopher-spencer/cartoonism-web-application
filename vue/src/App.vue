<template>
  <div id="cartoonism-app">
    <div class="header" id="header">
      <TheHeaderView />
    </div>
    <main>
      <router-view />
    </main>
  </div>
</template>

<script>
import TheHeaderView from './views/TheHeaderView.vue'

export default {
  components: {
      TheHeaderView
    }

}
</script>


<style>

</style>
