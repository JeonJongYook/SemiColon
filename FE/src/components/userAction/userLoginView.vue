<template>
  <div class="login">
    <h1 style="text-align: center">Welcome To SemiColon</h1>
    <form class="loginform">
      <p>
        <label for="memberIdInput">이메일</label>
        <input
          type="text"
          id="memberIdInput"
          class="input_text"
          ref="memberIdInput"
          v-model.trim="memberEmail"
          placeholder="이메일을 입력하세요."
        />
      </p>
      <p>
        <label for="memberPasswordInput">패스워드</label>
        <input
          type="password"
          id="memberPasswordInput"
          class="input_text"
          ref="memberPasswordInput"
          v-model.trim="memberPassword"
          placeholder="패스워드를 입력하세요."
        />
      </p>
      <p class="buttons">
        <button @click.prevent="doLogin" class="button blue">로그인</button>
        <button @click.prevent="doCancel" class="button">취소</button>
      </p>
    </form>
    <p>{{ errorMessage }}</p>
  </div>
</template>

<script>
export default {
  name: "userLoginView",
  data: function () {
    return {
      memberEmail: "",
      memberPassword: "",
      errorMessage: "",
    };
  },
  methods: {
    doLogin() {
      if (this.memberEmail == "") {
        alert("이메일을 입력하세요.");
        this.$refs.memberIdInput.focus();
        return;
      } else if (this.memberPassword == "") {
        alert("패스워드를 입력하세요.");
        this.$refs.memberPasswordInput.focus();
        return;
      }
      let memberInfo = { id: this.memberId, password: this.memberPassword };
      this.$store
        .dispatch("loginStore/doLogin", memberInfo)
        .then(() => {
          const returnUrl = window.location.search.replace(/^\?returnUrl=/, "");
          this.$router.push(returnUrl);
        })
        .catch((err) => {
          this.errorMessage = err.response.data.errormessage;
        });
    },
    doCancel() {
      this.$router.push("/login");
    },
  },
  mounted() {
    this.$refs.memberIdInput.focus();
  },
};
</script>

<style scoped>
.login {
  width: 800px;
  margin: 20px auto;
}
.loginform {
  width: 400px;
  margin: auto;
}
.loginform p > label {
  display: inline-block;
  width: 100px;
  font-size: 14px;
  padding-right: 10px;
}
.loginform p > .input_text {
  width: 200px;
  font-size: 14px;
  height: 32px;
}
.buttons {
  position: relative;
  height: 32px;
  margin-top: 20px;
}
.buttons > .button {
  overflow: visible;
  cursor: pointer;
  min-width: 125px;
  height: 32px;
  margin: 0 2px;
  padding: 0 15px;
  line-height: 32px;
  font-size: 14px;
  border: 1px solid #dfdfdf;
  background: #fff;
  border-radius: 10px;
}
.buttons > .button.blue {
  color: #fff;
  border-color: #0099d2 !important;
  background: #0099d2 !important;
}
</style>
