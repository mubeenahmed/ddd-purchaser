const bcrypt = require('bcryptjs');
const salt = bcrypt.genSaltSync(10);

function User(user)  {
    this.name = user.name;
    this.password = user.password;
    this.email = user.email;

    this.createPasswordHash = () => {
        this.password = bcrypt.hashSync(this.password, salt)
        return this;
    }

    this.compareHash = (password) => bcrypt.compareSync(password, this.password)
}

module.exports = User;