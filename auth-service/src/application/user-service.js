const express = require('express');
const User = require('../infrastructure/sequelize-conf').User;
const Profile = require('../infrastructure/sequelize-conf').Profile
const UserDomain = require('../domain/User'); 

const create = (req, res) =>
{
    req.getValidationResult()
        .then(validationHandler())
        .then(() => {
            const userDomain = new UserDomain(req.body)
            const { email, password, name } = userDomain.createPasswordHash()

            return User.create({
                email, password, name
            })
        })
        .then((data) => res.send(data))
        .catch((err) => {
            res.status(400).send(err.message)
        });
}

const addProfilePicture = (req, res) => 
{
    const user = req.user
    req.getValidationResult()
        .then(validationHandler())
        .then(() => {
            // Deactivate any user's profile picture
            Profile.update({ isActive: false }, { where: {user_id: user }})
                .then(result => {
                    Profile.create({ user_id: user, profile: profileUrl, isActive: true})
                        .then(result => res.send(200, {}))
                }) 
        })
}

const getUserById = (req, res) => {
    const id = req.param.id
    User.findById(id)
        .then(data => {
            res.send(200, { id: data.id, name: data.name })
        })
}

const getSelfUser = (req, res) => {
    const id = req.user
    User.findByPk(id)
        .then(data => {
            res.send(200, {id: data.id, name: data.name })
        })
}

const validationHandler = next => result => { 
    if (result.isEmpty()) return
    if (!next)
        throw new Error(result.array().map(i => `{ '${i.param}' : '${i.msg}' }` ))
    else 
        return next(new Error(result.array().map(i => `{ '${i.param}' : '${i.msg}' }`)))
}

module.exports.create = create
module.exports.getUserById = getUserById
module.exports.getSelfUser = getSelfUser