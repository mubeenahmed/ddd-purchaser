const sequelize = require('sequelize')

const user = (sequelize, DataTypes) => {
    const User = sequelize.define('user', {
        id: {
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        email: {
            type: DataTypes.STRING,
            unique: true
        },
        phoneNumber: {
            type: DataTypes.STRING,
            unique: true
        },
        password: {
            type: DataTypes.STRING
        },
        name: {
            type: DataTypes.STRING
        },
        emailVerified: {
            type: DataTypes.Boolean,
            default: false
        },
        phoneNumberVerified: {
            type: DataTypes.Boolean,
            default: false
        },
        isActive: {
            type: DataTypes.Boolean,
            default: false
        }
    });
    return User
}

module.exports = user