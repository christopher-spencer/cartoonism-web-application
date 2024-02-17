<template>
  <div id="cartoonism-app">
    <div class="header" id="header">
      <TheHeaderView />
    </div>
    <div class="main-view" id="main-view">
      <router-view />
    </div>
    <div class="footer" id="footer">
      <TheFooterView/>
    </div>
  </div>
</template>

<script>
import TheHeaderView from './views/TheHeaderView.vue'
import TheFooterView from './views/TheFooterView.vue';

export default {
  components: {
      TheHeaderView,
      TheFooterView
    }

}
</script>


<style>

</style>
