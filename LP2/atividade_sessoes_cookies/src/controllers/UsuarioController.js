const userSchema = require('../models/Usuario');
const bcrypt = require('bcryptjs');

module.exports = {
  async store (req, res) {
    let {login,password} = req.body;
    let salt = bcrypt.genSaltSync(10);
    let hash = bcrypt.hashSync(password,salt);
    let user = await userSchema.create({ login, password: hash });
    res.redirect('/login');
  },
  async auth(req,res){
    let {login,password} = req.body;
    let user = await userSchema.findOne({ login: login });
    if(user){
        let correct = bcrypt.compareSync(password, user.password);
        if(correct){
            req.session.user = {
                id: user._id,
                login: user.login
            }
            res.redirect('/');
        }else{
            res.redirect("/login?erro=true");
        }
    }else{
        res.redirect("/login?erro=true");
    }
  }
}