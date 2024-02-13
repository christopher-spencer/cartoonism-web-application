<template>
  <div class="create-blog-post" id="create-blog-post">

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
        imageUrl: "",
        createdAt: "",
        updatedAt: ""
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
    }
  }
}
</script>

<style>

</style>