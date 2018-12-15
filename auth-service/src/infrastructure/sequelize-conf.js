const Sequelize = require('sequelize');

const sequelize = new Sequelize('auth-purchaser', 'postgres', 'root', {
    host: 'localhost',
    dialect: 'postgresql',
    pool: {
      max: 10,
      min: 0,
      acquire: 30000,
      idle: 10000
    }
});

const models = {
  User: sequelize.import('./model/user')
};

Object.keys(models).forEach(key => {
  if ('associate' in models[key]) {
    models[key].associate(models);
  }
});

models.sequelize = sequelize;
models.Sequelize = Sequelize;

module.exports = models;