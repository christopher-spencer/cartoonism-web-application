import axios from "axios";

export default {

    getBlogPosts() {
        return axios.get('/blogposts');
    },

    getBlogPost(blogPostId) {
        return axios.get(`/blogposts/${blogPostId}`);
    },

    addBlogPost(blogPost) {
        return axios.post('/blogpost/create-blogpost', blogPost);
    },

    updateBlogPost(blogPost, blogPostId) {
        return axios.put(`/update-blogpost/${blogPostId}`, blogPost);
    },

    removeBlogPostByBlogPostId(blogPostId) {
        return axios.delete(`/blogpost/delete/${blogPostId}`);
    }

}