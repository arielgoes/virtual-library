import random

nome_arquivo = 'livros.txt'
arquivo = open(nome_arquivo, 'w')
arquivo.seek(0)
material = ['CAPA_DURA', 'BORRACHA', 'PLASTICO']
preco = ['10', '20', '30', '40', '50', '60', '100']
autor = ['STEPHEN_KING', 'BERNARD_CORNWELL', 'KARL_MARX', 'CARL_SEGAN', 'LUDWIG_VON_MISES', 'HANS_HERMANN_HOPPE']
editora = ['EDITORA_1', 'EDITORA_2', 'EDITORA_3']

for i in range(50):
	randPreco = int(random.choice(preco))
	texto = str(i) + ';' + 'Livro ' + str(i) + ';' + 'Livro ' + str(i) + ' eh o ' + str(i) + '-esimo livro;' + random.choice(material) + ';' + '00/00/0000;' + str(randPreco) + '.0;' + str(randPreco/2) + ';' + str(random.randint(0, 29)) + ';' + random.choice(editora) +  ';' + random.choice(autor) + '\n'  
	arquivo.write(texto)

arquivo.close()
