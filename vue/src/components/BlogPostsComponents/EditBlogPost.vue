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
  }
}
</script>

<style>

</style>