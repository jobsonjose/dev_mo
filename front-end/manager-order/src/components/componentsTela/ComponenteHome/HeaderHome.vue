<template>
  <div class="container-nave">
      <div class="row-tv">
          <div v-on:click="principal()" class="title-nave">Logo-Principal</div>
          <div v-on:click="assinatura()" class="title-nave">Assinaturas</div>
          <div v-on:click="grupo()" class="title-nave">Grupos</div>
          <div v-on:click="beneficio()" class="title-nave">Beneficios</div>
      </div>
  </div>
</template>

<script>
export default {
  name: 'HeaderHome',
  data () {
    return {
      msg: 'Page do meetup Eduta'
    }
  },
  methods:{
    principal(){
      this.$router.push("/");
    },
    assinatura(){
      this.$router.push("/assinatura");
    },
    grupo(){
      this.$router.push("/grupo");
    },
    beneficio(){
      this.$router.push("/beneficio");
    }
  }
}
</script>

<style scoped>
.row-tv{
    float: left;
    width: 100%;
}
.title-nave{
    float: left;
    padding: 0.5% 9%;
    color: white;
    transition: 1s;
}
.container-nave{
    width: 100%;
    float: left;
    background: #d82e52;
}
.title-nave:hover{
  color: rgba(247, 223, 106, 0.77);

}
</style>
