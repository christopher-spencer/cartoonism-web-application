<template>
    <div v-if="isLoading">
      <!-- Insert Loading Indicator or Message -->
      <p>Loading...</p>
    </div>
    <div v-else>
        <BlogPost :blogPost="blogPost"/>
    </div>
  </template>
  
  <script>
  import BlogPost from '../../components/BlogPostsComponents/BlogPost.vue';
  import BlogPostsService from '../../services/BlogPostsService';

  export default {
    name: "BlogPostView",
    components: {
        BlogPost
    },
    data() {
      return {
        blogPost: {},
        isLoading: true
      }
    },
    created() {
      const postId = this.$route.params.id;
      BlogPostsService.getBlogPost(postId)
      .then((response) => {
        this.blogPost = response.data;
        this.isLoading = false;
      })
      .catch((error) => {
        console.error('Error fetching blog post:', error);
        this.isLoading = false;
      });
    }
  }
  </script>
  
  <style>
  
  </style>