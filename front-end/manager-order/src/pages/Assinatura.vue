<template>
    <div class="container-equipe">
        <header-sub-nave></header-sub-nave>
        <header-nave></header-nave>
        <div class="container-assinatura">
            <card-design    titulo="Assinatura Grátis"
                            description="Permite o uso da plataforma de forma simples e com o controle de um estoque. Porém pode utilizar de cadastradamento e controle de produtos." 
                            image="https://imagens-revista-pro.vivadecora.com.br/uploads/2018/06/reuniao-de-equipe-como-fazer-768x403.jpg">
            </card-design>
            <card-design    titulo="Assinatura Premium"
                            description="Assinatura premium permite um controle de mais de um estoque e com essa permissão é liberado um filtro aprimorado. A visão do estoque ficar melhor com graficos" 
                            image="https://imagens-revista-pro.vivadecora.com.br/uploads/2018/06/reuniao-de-equipe-como-fazer-768x403.jpg">
            </card-design>
            <card-design    titulo="Assinatura Ultra"
                            description="Com assinatura ultra é possivel ter suporta da empresa do sistema e obter mais estoque sem limites" 
                            image="https://imagens-revista-pro.vivadecora.com.br/uploads/2018/06/reuniao-de-equipe-como-fazer-768x403.jpg">
            </card-design>
        </div>
    </div>
</template>
<script>
import headerHome from '@/components/componentsTela/ComponenteHome/HeaderHome.vue';
import subHeaderHome from '@/components/componentsTela/ComponenteHome/SubHeaderHome.vue'
import CardDesign from '@/components/componentsDesign/Card.vue'

export default {
    name: "Assinatura",
    data(){
        return {
            msg: 'Page do meetup Eduta'
        }
    },
    components:{
        'header-nave': headerHome,
        'header-sub-nave': subHeaderHome,
        'card-design': CardDesign
    }     
}
</script>
<style scoped>
.container-equipe{
    float: left;
    width: 100%;
    margin-top: 0.5%;
}
</style>