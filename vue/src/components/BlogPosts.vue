<template>
    <div class="blog-posts">
        <h1>Blog Posts Component</h1>
        <div class="divider"></div>
        <div class="blog-post" v-for="(blogPost, index) in blogPosts" :key="index">
            <div class="blog-post-header">
                <h3> Blog Post Name: {{blogPost.name}}!!! </h3>
            </div>
            <div class="blog-post-author">
                Author: {{blogPost.author}}
            </div>
            <br>
            <div class="blog-post-created-date">
                Date: {{blogPost.createdAt}}
            </div>
            <br>
            <div class="blog-post-description">
                Description: {{blogPost.description}}
            </div>
            <br>
            <div class="blog-post-image">
                Image: {{blogPost.imageName}}
            </div>
            <br>
            <div class="blog-post-content">
                Content: {{blogPost.content}}
            </div>
            <br>
            <div class="divider"></div>
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

.divider {
    border-style: double;
    background-color: blueviolet;
}
</style>