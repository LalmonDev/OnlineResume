<template>
  <div>
   <h1>welcome {{user}}</h1>
  </div>
</template>

<script>
  export default {
    data(){
      return{
        user: this.$route.query.id
      }
    }
  }
</script>

<style scoped>

</style>
