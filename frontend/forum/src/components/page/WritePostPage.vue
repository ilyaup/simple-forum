<script>
import axios from 'axios'
import { inject, ref } from 'vue'

export default {
    data() {
        return {
            post: {
                title: "",
                content: ""
            },
            user: inject('logged_user', ref(null))
        }
    },
    methods:{
        writePost(userId, title, content) {
            axios.post("http://localhost:8081/api/post/create_post", {userId, title, content})
        }
    }
}
</script>

<template>
    <h2>Write post</h2>
    <div v-if="user" class="write-post">
        <form>
            <fieldset class="flex">
                <label><input type="text" placeholder="Title" v-model="post.title"></label>
            </fieldset>
            <textarea placeholder="Input article's text here:" v-model="post.content"></textarea>
            <input type="submit" value="Post" v-on:click="writePost(user.id, post.title, post.content)"/>
        </form>
    </div>
    <div v-else>
        Log in to write posts
    </div>
    {{ user }}
</template>

<style scoped>
.write-post {
    height: 200px;
        display: flex;
        align-items: center;
        justify-content: center;
}
</style>