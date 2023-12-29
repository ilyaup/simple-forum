<template>
    <article class="card post">
        <header>
            <h3 class="title">{{ post.title }}</h3>
        </header>
        <div class="author">Author: {{ post.authorLogin }}</div>
        <div class="card content">{{ post.content }}</div>
        <footer class="likes"><button class="like error">Like</button> 
            Likes: {{ post.likes }}
            </footer>
    </article>
</template>

<script>
export default {
    props: ["post"]
}
</script>

<style scoped>

    .content {
        border: 0px;
        background-color: #c0c0c0;
    }
     .post {
        width: 50%;
        padding: 5px;
        margin: 3px 0;
    }
    .likes {
        float: right;
    }
    .like {
        display: inline;
        /* background-color:crimson; */
    }
</style>