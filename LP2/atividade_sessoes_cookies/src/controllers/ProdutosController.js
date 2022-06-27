const produtos = [
  {
    nome: "Liquidificador",
    categoria: "Eletrodomesticos",
    imagem: "1.jpg",
    id: 1
  },
  {
    nome: "Geladeira Tsunami",
    categoria: "Eletrodomesticos",
    imagem: "2.jpg",
    id: 2
  },
  {
    nome: "Freezer",
    categoria: "Eletrodomesticos",
    imagem: "3.jpg",
    id: 3
  },
  {
    nome: "Jaqueta Jeans",
    categoria: "Vestuario",
    imagem: "4.png",
    id: 4
  },
  {
    nome: "Casaco TEDDY",
    categoria: "Vestuario",
    imagem: "5.jpg",
    id: 5
  },
  {
    nome: "Calça Cargo",
    categoria: "Vestuario",
    imagem: "6.jpg",
    id: 6
  },
  {
    nome: "Air jordan 4",
    categoria: "Calcados",
    imagem: "7.jpg",
    id: 7
  },
  {
    nome: "Vans Old School",
    categoria: "Calcados",
    imagem: "8.jpg",
    id: 8
  },
  {
    nome: "Tenis com rodinha",
    categoria: "Calcados",
    imagem: "9.jpg",
    id: 9
  },
  {
    nome: "Fone Morcego",
    categoria: "Eletronicos",
    imagem: "10.jpg",
    id: 10
  },
  {
    nome: "Mouse",
    categoria: "Eletronicos",
    imagem: "11.jpg",
    id: 11
  },
  {
    nome: "Teclado",
    categoria: "Eletronicos",
    imagem: "12.jpg",
    id: 12
  }
]
module.exports = {
  getAll() {
    return produtos;
  },
  async getById(id) {
    const produto = produtos.find(p => p.id == id);
    return produto
  },
}