<template>
    <div v-if="isLoading">
      <!-- Insert Loading Indicator or Message -->
      <p>Loading...</p>
    </div>
    <div class="blog-post-container" v-else>
      <div class="blog-post">
        <BlogPost :blogPost="blogPost"/>
      </div>
      <div class="edit-blog-post-button">
        <EditBlogPostView/>
      </div>
    </div>
  </template>
  
  <script>
  import BlogPost from '../../components/BlogPostsComponents/BlogPost.vue';
  import BlogPostsService from '../../services/BlogPostsService';
  import EditBlogPostView from './EditBlogPostView.vue';

  export default {
    name: "BlogPostView",
    components: {
        BlogPost,
        EditBlogPostView
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