const expressValidator = require('express-validator')
const express = require('express')
const bodyParser = require('body-parser')
const models = require('./infrastructure/sequelize-conf')
const userRoute = require('./route/user-route');
const authRoute = require('./route/auth-route')



const app = express()
const port = 3000

app.use(bodyParser.json())
app.use(expressValidator())

app.use('/api', userRoute)
app.use('/api', authRoute)


models.sequelize.sync().then(() => {
    app.listen(port, () => console.log(`app listening on port ${port}!`))
})
