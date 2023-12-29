<script>
import PostComponent from "../PostComponent.vue"
import jsonPosts from "../../../assets/posts.json"
import axios from 'axios'

export default {
    components: {
        PostComponent
    },
    data() {
        return {
            posts: jsonPosts
        }
    },
    mounted() {
        axios.get("http://localhost:8081/api/post/posts").then(response => {
            this.posts = response.data;
        });
        
        this.posts = jsonPosts
    }
}
</script>

<template>
    <h2>Posts</h2>
    <div class="posts">
        <PostComponent v-for="post in posts" :post="post" :key="post.postId" />
    </div>
</template>

<style scoped>
.posts {
    display: grid;
    place-items: center;
}
</style>