<template>
    <div class="container-linha">
      <div class="title-linha">{{ title }}</div>
      <div class="linha-design"></div>
      <div class="linha-design"></div>
      <div class="linha-design"></div>
    </div>
</template>

<script>

export default {
  name: 'Row',
  props:{
    title: {
      type: String,
      default: "Projetos"
    }
  },
  data () {
    return {
      msg: 'Page do meetup Eduta'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.container-linha{
  width: 100%;
  margin-top: 1%;
  float: left;
}
.linha-design{
    width: 100%;
    height: 10px;
    background: #d82e52;
    margin-top: 0.5%;
}
.title-linha{
  float: left;
  padding: 0.6%;
  width: 18%;
  margin: 0.8% 41%;
  background: White;
  border-radius: 30px;
}
</style>
