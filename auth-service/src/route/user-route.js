
const { body } = require('express-validator/check')
const express = require('express')
const router = express.Router()
const passport = require('passport')

const userService = require('../application/user-service')

/**
 * To register new users, call /create 
 */
router.post('/user/create', 
    [ body('email', 'Email is required').isEmail().exists(),
    body('password', 'Password is required and 6 length min').exists().isLength(6),
    body('name', 'Name is required').exists() ],
    userService.create)

/**
 * This route takes Authorize token, and fetching ID from the Token to get 
 * information
 */
router.get('/user', passport.authenticate('jwt', {session: false}), userService.getSelfUser)
router.put('/profile', passport.authenticate('jwt', {session: false}), userService.addProfilePicture)

module.exports = router