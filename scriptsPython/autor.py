import random

nome_arquivo = 'autores.txt'
arquivo = open(nome_arquivo, 'w')    
arquivo.seek(0)
material = ['CAPA_DURA', 'BORRACHA', 'PLASTICO']
preco = ['10', '20', '30', '40', '50', '60', '100']
categoria = ['ADMINISTRACAO', 'ARTES', 'HQS', 'DIREITO', 'ECONOMIA']
autor = ['STEPHEN_KING', 'BERNARD_CORNWELL', 'KARL_MARX', 'CARL_SEGAN', 'LUDWIG_VON_MISES', 'HANS_HERMANN_HOPPE']
editora = ['EDITORA_1', 'EDITORA_2', 'EDITORA_3']
livro = list()

for k in range(50):
	livro.append('Livro ' + str(k))

for a in range(len(autor)):
	randNumLivros = random.randint(0, 10)
	result = []
	for r in range(randNumLivros):
		randLivro = random.choice(livro)

		if randLivro not in result:
			result.append(randLivro)			
			texto = autor[a] + ';' + '00/00/0000;' + '00/00/0000;' + 'ALEGRETE;' + 'PORTO_ALEGRETE;' + 'UM MERO ESCRITOR;' + randLivro + '\n'
			arquivo.write(texto)
	result.clear()		
arquivo.close()
