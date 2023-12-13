<template>
    <div>
        Users: <br />
        {{ users }}
    </div>
</template>
<script>

export default {
    name: "UsersView",
    props: ["users"]
}
</script>