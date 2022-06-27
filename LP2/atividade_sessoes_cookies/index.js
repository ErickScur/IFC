const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const session = require('express-session');
const mongoose = require('mongoose');
const routes = require('./src/routes');
const cookieParser = require('cookie-parser')

app.set("view engine", 'ejs');
app.use(express.static('public'));

app.use(cookieParser());

app.use(session({
    secret:"kfi0jfu9wdhfguwfhgu8sfhgu8sfhgushgusf", cookie:{ maxAge: 600000}
}));

mongoose.connect(
  'mongodb://root:123456@localhost:27017/lp2?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false' 
);

app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

app.use(routes);

app.listen(8080,()=>{
    console.log("Servidor Rodando");
});