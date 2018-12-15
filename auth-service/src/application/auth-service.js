const express = require('express');
const router = express.Router();
const User = require('../infrastructure/sequelize-conf').User;
const UserDomain = require('../domain/User'); 


const checkLogin = (req, res) => {
    const { email, password } = req.body
    User.findOne({ where: { email } })
        .then(data => {
            if(data == null)
            {
                return res.status(401).send('Oops! inccorect logged in credentails');
            }
            const userDomain = new UserDomain({email: data.email, password: data.password})
            const isPasswordOk = userDomain.compareHash(password)
            if(isPasswordOk)
            {
                return res.status(200).send('You are logged in! I will get you with token later')
            }
            return res.status(401).send('Oops! incorrect logged in credentials')
        }); 
}

module.exports.checkLogin = checkLogin