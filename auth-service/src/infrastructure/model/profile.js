const sequelize = require('sequelize')
const User = require('./user')

const profile = (sequelize, DataTypes) => {
    const Profile = sequelize.define('profile', {
        id: {
            type: DataTypes.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        profileUrl: {
            type: DataTypes.String
        },
        isActive: {
            type: DataTypes.Boolean
        }
    });

    Profile.belongsTo(User);
    return Profile
}

module.exports = Profile