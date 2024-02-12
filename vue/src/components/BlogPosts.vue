<template>
    <div class="blog-posts">
        <h1>Blog Posts Component</h1>
        <div class="divider"></div>
        <!-- <div class="blog-post" v-for="(blogPost, index) in blogPosts" :key="index">

        </div> -->
        <div v-for="(post, index) in blogPosts" :key="index" >
            <BlogPost :blogPost="post" />
            <div class="divider"></div>
        </div>
    </div>
</template>

<script>

import BlogPostsService from '../services/BlogPostsService';
import BlogPost from './BlogPost.vue';

export default {
    name: "blogPosts",
    components: {
        BlogPost
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