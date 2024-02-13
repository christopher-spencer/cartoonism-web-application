<template>
  <div class="header-container">
    <nav class="nav-container">
        <ul class="nav-list">
            <li class="nav-item">
                <router-link @click.prevent.stop v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
            </li>
            <li class="nav-item">
                <router-link @click.prevent.stop v-bind:to="{ name: 'blogPosts' }">Blog Posts</router-link>&nbsp;|&nbsp;
            </li>
            <li class="nav-item">
                  <router-link @click.prevent.stop v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
            </li>
        </ul>
    </nav>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

.nav-list {
  display: flex;
  justify-content: right;
  list-style: none;

}

.nav-item a:hover {

  color: orange;
} 

</style>