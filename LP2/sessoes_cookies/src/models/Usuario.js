const mongoose = require('mongoose');

const UsuarioSchema = new mongoose.Schema({
  login: { type: String, required: true },
  password: { type: String, required: true },
});

const usuarioSchema = mongoose.model('usuario', UsuarioSchema);
module.exports = usuarioSchema;