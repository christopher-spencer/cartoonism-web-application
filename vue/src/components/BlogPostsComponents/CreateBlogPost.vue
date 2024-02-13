<template>
  <div class="create-blog-post" id="create-blog-post">

  </div>
</template>

<script>
import BlogPostsService from "@/services/BlogPostsService.js"

export default {
  name: "CreateBlogPost",
  data() {
    return {
      showForm: false,
      createdBlogPost: {

      }
    }
  },
  computed: {
    isFormValid() {
      return this.createdBlogPost.name;
    }
  }
}
</script>

<style>

</style>