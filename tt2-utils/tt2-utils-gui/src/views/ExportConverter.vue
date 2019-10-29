<template>
  <div class="container page export-converter">
    <div
      class="page-flex-container"
    >
      <div
        class="input-area-wrapper"
      >
        <textarea v-model="exportedData" class="textarea full-height-textarea"/>
      </div>
      <div
        v-if="exportedDataOldFormat"
        class="output-area-wrapper"
      >
        <!-- <div
          style="overflow: auto; white-space: pre;"
        >
          {{ exportedDataOldFormat }}
        </div> -->
        <textarea ref="exportData" class="textarea full-height-textarea" v-model="exportedDataOldFormat" readonly/>
      </div>
      <div>
        <b-field position="is-right" class="options-area-wrapper">
          <p class="control">
            <b-button type="is-primary" @click="convert">Convert</b-button>
          </p>
          <p class="control">
            <b-button ref="copyButton" @click="copyToClipboard" :disabled="exportedDataOldFormat.length === 0">Copy to clipboard</b-button>
          </p>
        </b-field>
      </div>
    </div>
  </div>
</template>

<script>
import papaparse from 'papaparse'
export default {
  name: 'ExportConverter',
  data () {
    return {
      exportedData: '',
      exportedDataOldFormat: ''
    }
  },
  methods: {
    convert () {
      this.exportedDataOldFormat = ''
      let parsedData = papaparse.parse(this.exportedData, {
        header: true,
        error: (err) => {
          console.log(err)
        }
      })

      let filteredData = parsedData.data.filter((data, i) => {
        // return data['PlayerCode'] && parsedData.data.findIndex(
        //   d => d['PlayerCode'] === data['PlayerCode']
        // ) === i
        return data['TitanNumber'] === '0'
      })

      let mappedData = filteredData.map(data => {
        return {
          'Name': data['PlayerName'],
          'ID': data['PlayerCode'],
          'Attacks': data['TotalRaidAttacks'],
          // 'Damage': this.convertTotalDamage(data['Total Damage'])
          'Damage': parseInt(data['TitanDamage'])
        }
      })

      let orderedMap = mappedData.sort((a, b) => b.totalDmg - a.totalDmg)

      let withRank = orderedMap.map((d, i) => {
        return {
          'Rank': i + 1,
          ...d
        }
      })

      this.exportedDataOldFormat = papaparse.unparse(
        withRank,
        {
          header: true,
          newline: '\r\n'
        }
      )
    },
    convertTotalDamage (totalDmgStr) {
      let si = {
        'K': 1e3,
        'M': 1e6
      }

      let c = totalDmgStr.substring(totalDmgStr.length - 1)
      let numAsStr = totalDmgStr.substring(0, totalDmgStr.length - 1)

      return Math.round(parseFloat(numAsStr) * si[c])
    },
    copyToClipboard () {
      const el = this.$refs['exportData']
      el.select()
      el.setSelectionRange(0, 99999) /* For mobile devices */

      document.execCommand('copy')
      this.$refs['copyButton'].$el.focus()
    }
  }
}
</script>

<style>
.textarea {
  height: 100%;
  min-height: inherit !important;
  max-height: inherit !important;
}
</style>
