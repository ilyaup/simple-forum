<template>
    <div>
        Posts: <br />
        {{ posts }}
    </div>
</template>

<script>

export default {
    name: 'IndexView',
    props: ["posts"]
}
</script>