<template>
    <div class="container-nave">
        <div class="row">
          <div v-on:click="produtos()" class="title-nave">Produtos</div>
          <div v-on:click="estoques()" class="title-nave">Estoques</div>
          <div v-on:click="categorias()" class="title-nave">Categorias</div>
          <div v-on:click="relatorios()" class="title-nave">Relatorios</div>
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
    methods: {
        produto(){},
        estoques(){},
        categorias(){},
        relatorios(){}
    }
}
</script>
<style>
.row{
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
    padding-top: 8%;
    background: #4c1c26;
}
.title-nave:hover{
  color: rgba(247, 223, 106, 0.77);

}
</style>