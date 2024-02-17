<template>
  <div>
    <div class="blog-post-header">
        <router-link :to="{ name: 'blogPost' , params: { id: blogPost.id } }">
            <h3> Blog Post Name: {{blogPost.name}}!!! </h3>
        </router-link>
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
  </div>
</template>

<script>
export default {
    name: 'BlogPost',
    props: ['blogPost']
}
</script>

<style>

</style>