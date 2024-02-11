<template>
    <div class="blog-posts">
        <h1>Blog Posts Component</h1>
        <div class="blog-post" v-for="(blogPost, index) in blogPosts" :key="index">
            <div class="blog-post-header">
                <h3> Blog Post Name: {{blogPost.name}}!!! </h3>
            </div>
            <div>
                
            </div>
            <div class="blog-post-image">

            </div>
            <div class="blog-post-content">
                Blog Post Content: {{blogPost.content}}
            </div>
        </div>
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
.blog-posts {
    background-color: antiquewhite;
}
</style>