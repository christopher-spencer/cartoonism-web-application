<template>
  <div id="edit-blog-post">
    <div class="edit-blog-post-form">

    </div>
  </div>
</template>

<script>
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
    
  }
}
</script>

<style>

</style>