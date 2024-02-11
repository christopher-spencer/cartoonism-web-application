<template>
    <div class="blogpostsview">
        <h1>Blog Post View</h1>
        <div class="blogpostscomp">
            <BlogPosts />
        </div>
    </div>
</template>

<script>

import BlogPosts from '../components/BlogPosts.vue';
import BlogPostsService from '../services/BlogPostsService';


export default {
    name: "BlogPostsView",
    components: {
        BlogPosts
    },
    data() {
        return {
            blogPosts: [],
            isLoading: true
        }
    },
    computed: {
    },
    methods: {
    },
    created() {
      BlogPostsService.getBlogPosts().then((response) => {
      this.blogPosts = response.data;
      this.isLoading = false;
      console.log(this.blogPosts);
    }).catch((error) => {
      console.error('Error fetching blog posts:', error);
      this.isLoading = false; // Make sure to handle errors appropriately
    });
    }
}
</script>

<style scoped>
</style>