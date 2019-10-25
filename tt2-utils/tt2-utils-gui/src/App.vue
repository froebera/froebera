<template>
  <div id="app">
    <b-navbar type="is-primary">
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
