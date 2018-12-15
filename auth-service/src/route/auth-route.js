
const { body } = require('express-validator/check')
const express = require('express')
const router = express.Router()
const authService = require('../application/auth-service')

router.post('/login', authService.checkLogin)


module.exports = router