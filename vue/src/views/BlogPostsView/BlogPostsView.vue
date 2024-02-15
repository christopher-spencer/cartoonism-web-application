<template>
    <div class="blog-posts-view">
        <h1>Blog Post View</h1>
        <div>
            <CreateBlogPostView/>
        </div>
        <div class="blog-posts-comp">
            <BlogPosts />
        </div>
    </div>
</template>

<script>

import BlogPosts from '../../components/BlogPostsComponents/BlogPosts.vue';
import BlogPostsService from '../../services/BlogPostsService';
import CreateBlogPostView from './CreateBlogPostView.vue';


export default {
    name: "BlogPostsView",
    components: {
        BlogPosts,
        CreateBlogPostView
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
      this.isLoading = false; 
    });
    }
}
</script>

<style scoped>
.blog-posts-view {
    background-color: darkcyan;
}

h1 {
    color: white;
    text-align: center;
    padding-top: 15px;
}
</style>