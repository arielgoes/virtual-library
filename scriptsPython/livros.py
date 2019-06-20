import random

nome_arquivo = 'livros.txt
arquivo = open(nome_arquivo, 'w')
arquivo.seek(0)
material = ['CAPA_DURA', 'BORRACHA', 'PLASTICO']
preco = ['10', '20', '30', '40', '50', '60', '100']
categoria = ['ADMINISTRACAO', 'ARTES', 'HQS', 'DIREITO', 'ECONOMIA']
autor = ['STEPHEN_KING', 'BERNARD_CORNWELL', 'KARL_MARX', 'CARL_SEGAN', 'LUDWIG_VON_MISES', 'HANS_HERMANN_HOPPE']
editora = ['EDITORA_1', 'EDITORA_2', 'EDITORA_3']
for i in range(50):
    texto = str(i) + ';' + 'Livro ' + str(i) + ';' + 'Livro ' + str(i) + ' eh o ' + str(i) + '-esimo livro;' + random.choice(material) + ';' + random.choice(preco) + ';' + '00/00/0000;' + random.choice(categoria) + ';' + random.choice(autor) + ';' + random.choice(editora) + '\n'  

    print(texto)
    arquivo.write(texto)

arquivo.close()
