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
  align-items: center;
  list-style: none;
  padding: 0px;
}

nav {
  margin: 0 auto;
  padding: 20px 0 0 0;
  z-index: 1000;
}

nav ul li {
  display: inline-block;
}

nav ul li a {
  padding: 20px;
  font-family: 'Inter', sans-serif;
  color: rgba(0, 0, 0, 0.5);
  text-shadow: 1px 1px 1px rgba(255, 255, 255, 0.4);
  font-size: 22px;
  text-decoration: none;
  display: block;
}

.nav-item:hover {
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1), inset 0 0 1px rgba(255, 255, 255, 0.6);
  background: rbga(255, 255, 255, 0.1);
  color: rgba(0, 0, 0, 0.7);
}

</style>