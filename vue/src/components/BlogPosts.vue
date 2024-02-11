<template>
    <div class="blog-posts">
        <h1>Blog Posts Component</h1>
        <p v-for="(blogPost, index) in blogPosts" :key="index">
            Greetings from {{blogPost.blogPostName}}!!!
        </p>
    </div>
</template>

<script>

import BlogPostsService from '../services/BlogPostsService';

export default {
    name: "blogPosts",
    components: {
    },
    data() {
        return {
            blogPosts: []
        };
    },
    computed: {
    },
    methods: {
    },
    created() {
        BlogPostsService.getBlogPosts().then( (response) => {
            this.blogPosts = response.data;
        },


      )
    }
}
</script>

<style scoped>
</style>