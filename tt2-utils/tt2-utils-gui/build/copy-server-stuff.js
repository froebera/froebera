const fs = require('fs')
const path = require('path')

// destination.txt will be created or overwritten by default.
// fs.copyFile('server-stuff/.htaccess', 'dist/.htaccess', (err) => {
//   if (err) throw err
//   console.log('Copied server stuff')
// })

var copyRecursiveSync = function (src, dest) {
  var exists = fs.existsSync(src)
  var stats = exists && fs.statSync(src)
  var isDirectory = exists && stats.isDirectory()
  if (exists && isDirectory) {
    var destExists = fs.existsSync(dest)
    if (!destExists) {
      fs.mkdirSync(dest)
    }
    fs.readdirSync(src).forEach(function (childItemName) {
      copyRecursiveSync(path.join(src, childItemName),
        path.join(dest, childItemName))
    })
  } else {
    fs.copyFile(src, dest, (err) => {
      if (err) throw err
      console.log(`Copied ${src} to ${dest}`)
    })
  }
}

copyRecursiveSync('./server-stuff', './dist')
