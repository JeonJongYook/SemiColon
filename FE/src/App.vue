<template>
  <!--  <h1>Welcome To SemiColon</h1>-->
  <router-view />
  <!--  <h1>Welcome To SemiColon</h1>-->
  <!--  <nav>-->
  <!--    <div v-if="isLogin">-->
  <!--      {{ userNickname }}({{ userEmail }})님, <span v-html="greetingHtml"></span>-->
  <!--    </div>-->
  <!--    <div v-else>서비스를 이용하려면 로그인 먼저 해주세요~</div>-->
  <!--  </nav>-->
  <!--  <router-view />-->
  <!--  <p class="mt-5 mb-3 text-center">-->
  <!--    &copy; 2022 Incheon Electronic Meister High School-->
  <!--  </p>-->
</template>

<script>
// import welcomeView from "../src/views/HomeView.vue";

export default {
  // name: "TestComponent",
  // components: { welcomeView },
  // data: function () {
  //   return {
  //     userNickname: "testNick",
  //     userEmail: "test@test.com",
  //     isLogin: true,
  //     greetingHtml: '<span style="color:#0a45c7">안녕하세요.</span>',
  //   };
  // },
  // methods: {
  //   clearUserInput() {
  //     this.userNickname = "";
  //     this.userEmail == "";
  //   },
  // },
};
</script>

<style scoped>
h1 {
  /*color: #42b983;*/
  text-align: center;
}

/*#app {*/
/*  font-family: Avenir, Helvetica, Arial, sans-serif;*/
/*  -webkit-font-smoothing: antialiased;*/
/*  -moz-osx-font-smoothing: grayscale;*/
/*  text-align: center;*/
/*  color: #2c3e50;*/
/*}*/

/*nav {*/
/*  padding: 30px;*/
/*}*/

/*nav a {*/
/*  font-weight: bold;*/
/*  color: #2c3e50;*/
/*}*/

/*nav a.router-link-exact-active {*/
/*  color: #42b983;*/
/*}*/
</style>
