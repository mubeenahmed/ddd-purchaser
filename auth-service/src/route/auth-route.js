
const { body } = require('express-validator/check')
const express = require('express')
const router = express.Router()
const authService = require('../application/auth-service')
const JWTstrategy = require('passport-jwt').Strategy;
const ExtractJWT = require('passport-jwt').ExtractJwt;
const passport = require('passport')


// Middleware for authentication
passport.use(new JWTstrategy({
    secretOrKey : 'thisissecret',
    jwtFromRequest : ExtractJWT.fromAuthHeaderWithScheme('jwt')}, (token, done) => {
        try {
            return done(null, token.id);
        } 
        catch (error) { 
            done({auth: false});
        }
    }));

router.post('/login', authService.checkLogin)
module.exports = router