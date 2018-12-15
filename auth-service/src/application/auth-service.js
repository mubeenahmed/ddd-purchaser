const express = require('express');
const router = express.Router();
const User = require('../infrastructure/sequelize-conf').User;
const UserDomain = require('../domain/User'); 
const jwt = require('jsonwebtoken')

const checkLogin = (req, res) => {
    const { email, password } = req.body
    User.findOne({ where: { email } })
        .then(data => {
            if(data == null)
            {
                return res.status(401).send({auth: false});
            }
            const userDomain = new UserDomain({email: data.email, password: data.password})
            const isPasswordOk = userDomain.compareHash(password)
            if(isPasswordOk)
            {
                const auth = { auth: true, 
                    token: jwt.sign({id: data.id}, "thisissecret") 
                }
                return res.status(200).send(auth)
            }
            return res.status(401).send({auth: false})
        }); 
}

module.exports.checkLogin = checkLogin