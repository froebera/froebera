<template>
  <div class="joke-component">
    <p class="is-size-3" v-text="joke" />
    <div class="control">
      <button class="button is-light" @click="fetchJoke">Fetch new Joke</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'JokeComponent',
  data () {
    return {
      joke: ''
    }
  },
  created () {
    this.fetchJoke()
  },
  methods: {
    async fetchJoke () {
      console.log(process.env.VUE_APP_SERVICE_URL)
      const { data } = await axios.get(`${process.env.VUE_APP_SERVICE_URL}/joke`, {
        headers: {
          'Content-Type': 'text/plain'
        }
      })
      this.joke = data.joke
    }
  }
}
</script>
