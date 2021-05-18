<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  },
  data: () => ({
    usuarioCurrent: {
        id: 0,
        nome: "",
        cpf: "",
        email: "",
        senha: ""
    },
  }),
  mounted() {
      console.log(this.statusLogin);
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
body{
  margin: 0px !important;
}
</style>
