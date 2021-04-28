<template>
    <div class="container-card-home">
        <card-design    titulo="Estoque Company fitec" 
                    description="Esse grupo obteve um controle de produos de 120% durante 3 meses de utilização da plataforma Manager oder." 
                    image="https://imagens-revista-pro.vivadecora.com.br/uploads/2018/06/reuniao-de-equipe-como-fazer-768x403.jpg"></card-design>
        <card-design    titulo="Company Ribeiro" 
                    description="Empresa que trabalha com venda de varios peixes teve um controle de 140% em seus gastos com produto que não tinha mais uso no mercado, facilitando assim onde melhor investir." 
                    image="https://imagens-revista-pro.vivadecora.com.br/uploads/2018/06/reuniao-de-equipe-como-fazer-768x403.jpg"></card-design>
        <card-design    titulo="Empresa de seu BIU" 
                    description="Biu um grande vendedor de bebidas em geral e produtos de frios, estava passando por um descontrole digantestco por ter falta " 
                    image="https://imagens-revista-pro.vivadecora.com.br/uploads/2018/06/reuniao-de-equipe-como-fazer-768x403.jpg"></card-design>
    </div>
</template>
<script>
import CardDesign from '@/components/componentsDesign/Card.vue'
export default {
    name: 'InformativeHome',
    components:{
        'card-design': CardDesign
    },
    data(){
        return{
            msg: 'Page do meetup Eduta'
        }
    },
    method: {
        
    }    
}
</script>
<style scoped>
.container-card-home{
    min-width: 100%;
}
</style>