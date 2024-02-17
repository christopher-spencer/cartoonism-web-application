<template>
  <div id="edit-blog-post">
    <div class="edit-form-button" v-show="!showForm">
      <a href="#" v-on:click.prevent="showForm = true">
        <h2 class="edit-header">Edit Blog Post:</h2>
      </a>
    </div>
    <br>
    <form id="edit-blog-post-form" v-on:submit="editBlogPost()" v-if="showForm">

      <div class="edit-inputs-container">
        <div class="edit-input">
          <label class="input-label" for="name">Blog Post Name:</label>
          <input id="name" type="text" class="input-field" v-model="editedBlogPost.name" />
        </div>
        <div class="edit-input">
          <label class="input-label" for="author">Blog Post Author:</label>
          <input id="author" type="text" class="input-field" v-model="editedBlogPost.author" />
        </div>
        <div class="edit-input">
          <label class="input-label" for="description">Blog Post Description:</label>
          <input id="description" type="text" class="input-field" v-model="editedBlogPost.description" />
        </div>
        <div class="edit-input">
          <label class="input-label" for="content">Blog Post Content:</label>
          <input id="content" type="textarea" class="input-field" v-model="editedBlogPost.content" />
        </div>
        <div class="edit-input">
          <label class="input-label" for="imageName">Blog Post Image Name:</label>
          <input id="imageName" type="text" class="input-field" v-model="editedBlogPost.imageName" />
        </div>
        <div class="edit-input">
          <label class="input-label" for="imageUrl">Blog Post Image URL:</label>
          <input id="imageUrl" type="text" class="input-field" v-model="editedBlogPost.imageUrl" />
        </div>
      </div>

      <div class="edit-form-submission-buttons">
        <input class="cancel-button" v-on:click.prevent="hideForm()" type="button" value="Cancel" />
        <input class="reset-button" v-on:click.prevent="resetForm()" type="button" value="Reset Form" />
        <button class="submit-button" type="submit">Update</button>
      </div>

    </form>
  </div>
</template>

<script>
import BlogPostsService from '@/services/BlogPostsService';

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
      BlogPostsService.updateBlogPost(this.editedBlogPost, this.editedBlogPost.id)
        .then((response) => {
          console.log("Updated data:", response.data); // Log updated data

          if (response.status === 200) {
            if (response.data) {
              this.editedBlogPost = response.data;
              this.$store.commit("UPDATE_BLOG_POST", this.editedBlogPost);
              //this.hideForm();
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
    console.log('ID:', this.$route.params.id);
  }
}
</script>

<style>

</style>