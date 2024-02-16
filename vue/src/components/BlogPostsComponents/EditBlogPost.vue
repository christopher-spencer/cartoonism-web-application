<template>
  <div id="edit-blog-post">
    <div class="edit-blog-post-form">

    </div>
  </div>
</template>

<script>
import BlogPostsService from '../../services/BlogPostsService';

export default {
  name: "edit-blog-post",
  data() {
    return {
      showForm: false,
      editedBlogPost: {
        id: '',
        name: '',
        author: '',
        description: '',
        content: '',
        imageName: '',
        imageUrl: ''
      }
    };
  },
  computed: {
    isFormValid() {
      return (
        this.editedBlogPost.name && this.editedBlogPost.author 
        && this.editedBlogPost.description && this.editedBlogPost.content
        && this.editedBlogPost.imageName && this.editedBlogPost.imageUrl
      );
    }
  },
  methods: {
    getBlogPostData(blogPostId) {
      BlogPostsService.getBlogPost(blogPostId)
        .then((response) => {
          this.editedBlogPost = response.data;
        })
        .catch(function (error) {
          if (error.response) {
            if (error.response.status === 404) {
              alert(error.response.data.message);
            }
          }
        });
    }, 
    editBlogPost() {
      BlogPostsService.updateBlogPost(this.editedBlogPost.id)
        .then((response) => {
          if (response.status === 200) {
            if (response.data) {
              this.editBlogPost = response.data;
              // this.$store.commit("UPDATE_BLOGPOST", this.editedBlogPost);
            } else {
              console.error("Response data is missing 'id' property:", response.data);
            }
          } else {
            console.error("Unexpected status code:", response.status);
          }
        })
        .catch((err) => console.error("API Error:", err));
    },
    resetForm() {
      this.editedBlogPost = {
        id: '',
        name: '',
        author: '',
        description: '',
        content: '',
        imageName: '',
        imageUrl: ''
      };
    },
    hideForm() {
      this.showForm = false;
      this.resetForm();
    }
  },
  created() {
    this.getBlogPostData(this.$route.params.id);
  }
}
</script>

<style>

</style>