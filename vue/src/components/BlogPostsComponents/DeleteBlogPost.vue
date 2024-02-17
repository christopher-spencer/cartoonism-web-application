<template>
  <div class="delete-button-container">
    <button class="delete-button" v-on:click="deleteBlogPost(blogPost.id)">Delete Blog Post</button>
  </div>
</template>

<script>
export default {
  name: "DeleteBlogPost",
  data() {
    return {
      blogPost: {}
    }
  }
}
</script>

<style>

</style>