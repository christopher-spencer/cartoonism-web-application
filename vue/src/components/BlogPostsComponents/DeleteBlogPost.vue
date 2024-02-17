<template>
  <div class="delete-button-container">
    <button class="delete-button" v-on:click="deleteBlogPost(blogPost.id)">Delete Blog Post</button>
  </div>
</template>

<script>
import BlogPostsService from '../../services/BlogPostsService';

export default {
  name: "DeleteBlogPost",
  data() {
    return {
      blogPost: {
        id: '',
        name: '',
        author: '',
        description: '',
        content: '',
        imageName: '',
        imageUrl: ''
      }
    }
  },
  methods: {
    deleteBlogPost(id) {
      BlogPostsService.removeBlogPostByBlogPostId(id)
        .then((response) => {
          if (response.status === 204) {
            this.$router.push({ name: 'blogPosts' });
          }
        })
        .catch((error) => {
          console.error('Error deleting blog post:', error);
        });
    }
  },
  created() {
    BlogPostsService.getBlogPost(this.$route.params.id)
      .then((response) => {
        this.blogPost = response.data;
      })
      .catch((error) => {
        console.error('Error fetching blog post:', error);
      });
  }
}
</script>

<style>

</style>