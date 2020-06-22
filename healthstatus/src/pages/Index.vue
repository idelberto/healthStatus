<template>
    <q-page class="padding">
       <div class="column justify-center items-center">
            <br>
            <img alt="Quasar logo" src="~assets/hs-logo-full.svg" />
            <br>
            <q-input bordered class="large-form" placeholder="Usuário" v-model="user" :rules="[ requiredField ]"/>
            <br>
            <q-input bordered class="large-form" placeholder="Senha" type="password" v-model="password" :rules="[ requiredField ]"/>
            <a class="link align-rigth" href="https://www.w3schools.com">Esqueceu sua senha ?</a>
            <br>
            <q-btn class="large-form" color="primary" v-on:click="login()">Entrar</q-btn>
        </div>

        <q-footer bordered class="bg-white text-primary footer-large">
          <div class="column justify-center items-center footer-center">
            <a class="link" href="https://www.w3schools.com">Crie sua conta</a>
          </div>
        </q-footer>
    </q-page>
</template>

<script>
export default {
  name: 'PageIndex',
  data() {
    return {
      loggedUser: [],
      user: '',
      password: '',
      errored: false,
      loadUser: true    
    }
  },
    methods: {
    login: function () {
      this.loggedUser = []
      this.$axios.get('http://192.168.25.9:8080/v1/user/login?userName='+this.user+'&password='+this.password)
        .then(response => {
          this.loggedUser = response.data
          response.data = []
          if (this.loggedUser != [] ) {
            console.log('Logged User :',this.loggedUser.userName)
            return
          }
          else
          {
            this.showLoginFail()
          }
        })
        .catch(error => {
          console.log(error)
          this.errored = true
        })
        .finally(() => this.loadUser = false)

    },

    requiredField (val) {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve(!!val || '* Campo obrigatório')
        }, 500)
      })
    },

    showLoginFail () {
      this.$q.notify({
        message: 'Usuário ou senha inválidos',
        color: 'red'
      })
    }

  }
}
</script>

<style lang="scss">

  .footer-large{
    height: 5%;
  }
  .footer-center{
    margin-top: 6px;
  }
  .align-rigth {
    margin-right: -65%;
    font-size: 70%;
  }
  .link {
    color: $secondary;
    text-decoration:none; 
  }
  .large-form {
    width: 90%;
  }
</style>
