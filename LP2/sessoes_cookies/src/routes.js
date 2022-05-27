const express = require('express');
const routes = express.Router();
const UserController = require('./controllers/UsuarioController');
const authenticate = require('./authenticate');

routes.get("/", authenticate, (req,res) => {
  res.render("index");
});

routes.get("/login/",(req,res)=>{
  const erro = req.query.erro;
  res.render("login", {
    erro
  });
});

routes.get("/user/create" , (req,res) => {
  res.render("criar-usuario");
});

routes.post("/limparcookie", (req, res) => {
  const { chave } = req.body;
  res.clearCookie(chave);
  res.redirect("/");
});

routes.post("/setcookie", (req, res) => {
  const { chave, valor, tempo } = req.body;
  res.cookie(chave, valor, {
    maxAge: tempo * 60 * 1000,
  });
  res.redirect("/");
});

routes.post("/user/create", UserController.store);
routes.post("/user/auth", UserController.auth);

module.exports = routes;