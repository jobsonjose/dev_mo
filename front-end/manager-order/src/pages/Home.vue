<template>
  <div class="container">
    <header-sub-nave></header-sub-nave>
    <header-nave></header-nave>
    <banner-home></banner-home>
    <row-design></row-design>
    <info-home></info-home> 
    <about-home></about-home>
    <footer-home></footer-home>
  </div>
</template>

<script>
import bannerHome from '@/components/componentsTela/ComponenteHome/BannerHome.vue';
import rowDesign from '@/components/componentsDesign/Row.vue';
import informativeHome from '@/components/componentsTela/ComponenteHome/InformativeHome.vue';
import aboutHome from '@/components/componentsTela/ComponenteHome/AboutHome.vue';
import footerHome from '@/components/componentsTela/ComponenteHome/FooterHome.vue';
import Usuario from '@/service/usuario.js';
import headerHome from '@/components/componentsTela/ComponenteHome/HeaderHome.vue';
import subHeaderHome from '@/components/componentsTela/ComponenteHome/SubHeaderHome.vue';

export default {
  name: 'Home',
  components: {
    'banner-home': bannerHome,
    'row-design': rowDesign,
    'info-home': informativeHome,
    'about-home': aboutHome,
    'footer-home': footerHome,
    'header-nave': headerHome,
    'header-sub-nave': subHeaderHome
  },
  data () {
    return {
      msg: 'Page do meetup Eduta'
    }
  },
  mounted() {
      Usuario.listar().then(resposta => {
      console.log(resposta);
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
