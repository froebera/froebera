<template>
  <div id="app">
    <b-navbar type="is-primary">
      <template #brand>
        <b-navbar-item class="navbar-item is-size-4" tag="router-link" :to="{ name: 'home'}">
          TT2 Utils
        </b-navbar-item>
      </template>
      <template #start>
        <b-navbar-item tag="router-link" :to="{ name: 'export-converter'}">
          Export Converter
        </b-navbar-item>
      </template>
    </b-navbar>
    <router-view/>
  </div>
</template>

<style lang="scss">
@import "./design"
</style>
