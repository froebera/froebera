<template>
  <div class="home hero is-fullheight is-primary">
    <div class="hero-body">
      <div class="container">
        <joke-component />
      </div>
    </div>
  </div>
</template>

<script>
import JokeComponent from "../components/joke-component"

export default {
  name: 'home',
  components: { JokeComponent }
}
</script>
