<template>
    <div class="container-nave-dbh">
        <div class="row-tv">
          <div v-on:click="produtos()" class="title-nave-dbh">Produtos</div>
          <div v-on:click="estoques()" class="title-nave-dbh">Estoques</div>
          <div v-on:click="categorias()" class="title-nave-dbh">Categorias</div>
          <div v-on:click="pedido()" class="title-nave-dbh">Pedidos</div>
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
        estoques(){
            this.$router.push("/dashboard/estoque/"+this.idUsuario);
        },
        categorias(){
            this.$router.push("/dashboard/categoria/"+this.idUsuario)
        },
        pedido(){
            this.$router.push("/dashboard/pedido/"+this.idUsuario)
        },
        sair(){
            this.$router.push("/")
        }
    }
}
</script>
<style scoped>
.row-tv{
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