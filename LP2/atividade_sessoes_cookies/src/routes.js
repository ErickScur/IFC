const express = require('express');
const routes = express.Router();
const UserController = require('./controllers/UsuarioController');
const authenticate = require('./authenticate');
const ProdutosController = require('./controllers/ProdutosController');

routes.get("/", authenticate, (req,res) => {
  const produtos = ProdutosController.getAll();
  res.render("index", {
    produtos,
  });
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

routes.get("/produto/:id", (req, res) => {
  const id = req.params.id;
  ProdutosController.getById(id).then(produto => {
    const cookie = req.cookies[produto.categoria];
    if (!cookie) {
      res.cookie(produto.categoria, 1);
    } else {
      const clicks = parseInt(cookie) + 1;
      res.clearCookie(produto.categoria);
      res.cookie(produto.categoria, clicks);
    }
    const cookie2 = req.cookies[`${produto.categoria}ultimoAcesso`];
    if (!cookie2) {
      res.cookie(`${produto.categoria}ultimoAcesso`, new Date().toString());
    } else {
      res.clearCookie(`${produto.categoria}ultimoAcesso`);
      res.cookie(`${produto.categoria}ultimoAcesso`, new Date().toString());
    }
    res.redirect("/");
  });
  
});

routes.post("/user/create", UserController.store);
routes.post("/user/auth", UserController.auth);

module.exports = routes;