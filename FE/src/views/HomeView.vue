<template>
  <div class="homeView">
    <ul class="navigation">
      <li><a href="/" class="active">Home</a></li>
      <!-- <li v-if="!$store.state.account.id"><a href="/login">로그인</a></li>-->
      <li><a href="/register">서비스 가입하기</a></li>
      <!-- <li v-else><a to="login" @click="logout()">로그아웃</a></li>-->
      <li><a href="/login">서비스 이용하기</a></li>
      <!--      <li><a href="#">Contact</a></li>-->
    </ul>
  </div>
  <br />
  <h1>Welcome To SemiColon</h1>
  <router-view />
</template>

<script>
// @ is an alias to /src
// import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "HomeView",
  components: {
    // HelloWorld,
  },
};
</script>

<style scoped>
h1 {
  font-size: 40px;
  min-width: 15px;
  white-space: nowrap;
  margin: 0;
  position: fixed;
  color: transparent;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

h1::before {
  content: "Welcome To SemiColon";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  color: black;
  overflow: hidden;
  border-right: 1px solid black;
  animation: typing 5s steps(31) infinite;
}

@keyframes typing {
  0% {
    width: 0%;
  }
  50% {
    width: 100%;
  }
  100% {
    width: 0%;
  }
}
/*@keyframes typing{*/
/*  from{ width: 0; }*/
/*}*/

/*@keyframes cursor{*/
/*  50%{ border-color: transparent; }*/
/*}*/

/*h1{*/
/*  width: 5ch;*/
/*  overflow: hidden;*/
/*  white-space: nowrap;*/
/*  border-right: .05em solid black;*/
/*  animation: typing 5s steps(5),*/
/*  cursor 1s steps(1) infinite;*/
/*}*/

/*.wrapper {*/
/*  height: 100vh;*/
/*  !*This part is important for centering*!*/
/*  display: grid;*/
/*  place-items: center;*/
/*}*/

/*.typing-demo {*/
/*  width: 22ch;*/
/*  animation: typing 2s steps(22), blink .5s step-end infinite alternate;*/
/*  white-space: nowrap;*/
/*  overflow: hidden;*/
/*  border-right: 3px solid;*/
/*  font-family: monospace;*/
/*  font-size: 2em;*/
/*}*/

/*@keyframes typing {*/
/*  from {*/
/*    width: 0*/
/*  }*/
/*}*/

/*@keyframes blink {*/
/*  50% {*/
/*    border-color: transparent*/
/*  }*/
/*}*/

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}

body {
  overflow-y: hidden;
  background: #fff;
  min-height: 100vh;
}

header {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  padding: 30px 100px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  z-index: 1000;
}

header > a {
  font-size: 42px !important;
}

.logo {
  color: #112434;
  font-weight: 700;
  font-size: 3.5em;
  text-decoration: none;
}

.navigation {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 45px;
}

.navigation li {
  list-style: none;
  font-size: 1.2em;
}

.navigation li a {
  text-decoration: none;
  padding: 6px 15px;
  color: #112434;
  border-radius: 20px;
}

.navigation li a:hover,
.navigation li a.active {
  background: #112434;
  color: #fff;
}
</style>
