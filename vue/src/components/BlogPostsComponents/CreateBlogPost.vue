<template>
  <div class="create-blog-post" id="create-blog-post">
    <div class="create-blog-post-button" v-show="!showForm">
      <a href="#" v-on:click.prevent="showForm = true">
        <h2 class="create-blog-post-header">Create a New Blog Post:</h2>
      </a>
    </div>
    <br>
    <form id="create-blog-post-form" v-on:submit.prevent="createBlogPost()" v-if="showForm">
      <div class="input-name">
        <label class="input" for="name" >Blog Post Name:</label>
        <input id="name" type="text" placeholder="Name your Blog Post" v-model="createdBlogPost.name" />
      </div>
      <div class="input-author">
        <label class="input" for="author" >Blog Post Author:</label>
        <input id="author" type="text" placeholder="Who's the Author?" v-model="createdBlogPost.author" />
      </div>
      <div class="input-description">
        <label class="input" for="description">Blog Post Description:</label>
        <input id="description" type="text" placeholder="Write a brief description of the Blog Post" v-model="createdBlogPost.description">
      </div>
      <div class="input-content">
        <label class="input" for="content">Blog Post Content:</label>
        <input id="content" type="text" placeholder="Insert Blog Post Content here" v-model="createdBlogPost.content">
      </div>
      <div class="input-image-name">
        <label class="input" for="image-name">Image Name:</label>
        <input id="image-name" type="text" placeholder="Name your Image" v-model="createdBlogPost.imageName">
      </div>
      <div class="input-image-url">
        <label class="input" for="image-url">Image URL:</label>
        <input id="image-url" type="text" placeholder="Insert a URL to your image" v-model="createdBlogPost.imageUrl">
      </div>
      <div class="create-blog-post-buttons">
        <input class="cancel-button" v-on:click.prevent="hideForm" type="button" value="Cancel" />
        <input class="reset-button" v-on:click.prevent="resetForm()" type="button" value="Reset Form" />
        <input class="submit-button" type="submit" value="Submit Form" v-bind:disabled="!isFormValid" />
      </div>
    </form>
  </div>
</template>

<script>
import BlogPostsService from "@/services/BlogPostsService.js"

export default {
  name: "CreateBlogPost",
  data() {
    return {
      showForm: false,
      createdBlogPost: {
        id: "",
        name: "",
        author: "",
        description: "",
        content: "",
        imageName: "",
        imageUrl: ""
      }
    }
  },
  computed: {
    isFormValid() {
      return this.createdBlogPost.name;
    }
  },
  methods: {
    createBlogPost() {
      this.id = this.$store.state.user.id;

      BlogPostsService.addBlogPost(this.createBlogPost)
        .then((response) => {
          if (response.status === 201) {
            if (response.data) {
              this.createdBlogPost = response.data;
              console.log(this.createdBlogPost);
              // this.$router.push({
              //   name: "BlogPost",
              //   params: { id: this.createdBlogPost.id } 
              // });
              this.resetForm();
            } else {
              console.error("Response data is missing 'id' property:", response.data);
            } 
          } else {
            console.error("Unexpected status code:", response.status);
          }
        })
        .catch((error) => console.error("API Error:", error));
    },
    resetForm() {
      this.createdBlogPost = {
        id: "",
        name: "",
        author: "",
        description: "",
        content: "",
        imageName: "",
        imageUrl: ""
      };
    },
    hideForm() {
      this.showForm = false;
      this.resetForm();
    }
  }
}
</script>

<style>

</style>