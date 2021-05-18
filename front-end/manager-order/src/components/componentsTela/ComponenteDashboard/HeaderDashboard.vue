<template>
    <div class="container-nave-dbh">
        <div class="row">
          <div v-on:click="produtos()" class="title-nave-dbh">Produtos</div>
          <div v-on:click="estoques()" class="title-nave-dbh">Estoques</div>
          <div v-on:click="categorias()" class="title-nave-dbh">Categorias</div>
          <div v-on:click="relatorios()" class="title-nave-dbh">Relatorios</div>
          <div v-on:click="sair()" class="title-nave-dbh">Sair</div>
        </div>
    </div>
</template>
<script>
export default {
    name: 'HeaderDashboard',
    data () {
        return {
            msg: 'Page do meetup Eduta'
        }
    },
    props:{
        idUsuario: Number
    },
    methods: {
        produtos(){
            this.$router.push("/dashboard/produto/"+this.idUsuario);
        },
        estoques(){},
        categorias(){},
        relatorios(){},
        sair(){
            this.$router.push("/")
        }
    }
}
</script>
<style scoped>
.row{
    float: left;
    width: 100%;
}
.title-nave-dbh{
    float: left;
    padding: 0.5% 7.5%;
    color: white;
    transition: 1s;
}
.container-nave-dbh{
    width: 100%;
    float: left;
    padding-top: 8%;
    background: #4c1c26;
}
.title-nave-dbh:hover{
  color: rgba(247, 223, 106, 0.77);

}
</style>